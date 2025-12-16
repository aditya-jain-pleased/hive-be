package com.example.demo.domain.ai.impl;

import com.example.demo.domain.ai.AiAdapter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OpenAiAdapter implements AiAdapter {

    private static final String AI_NAME = "OpenAI";

    @Value("${openai.api.key:}")
    private String apiKey;

    @Value("${openai.model:gpt-4o-mini}")
    private String model;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String getName() {
        return AI_NAME;
    }

    @Override
    public String ask(String question) throws Exception {
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("Missing OpenAI API key. Set property 'openai.api.key' or env var 'OPENAI_API_KEY'.");
        }
//        System.out.println("here's the key = " + apiKey);

        // Build request body for Chat Completions
        Map<String, Object> body = new HashMap<>();
        body.put("model", model);
        body.put("messages", List.of(
                Map.of("role", "system", "content", "You are a helpful assistant."),
                Map.of("role", "user", "content", question)
        ));
        body.put("temperature", 0.7);

        String json = objectMapper.writeValueAsString(body);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                .timeout(Duration.ofSeconds(60))
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json, StandardCharsets.UTF_8))
                .build();

        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(20))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

        if (response.statusCode() < 200 || response.statusCode() >= 300) {
            String bodyText = response.body();
            String reason;
            try {
                JsonNode error = objectMapper.readTree(bodyText).path("error");
                reason = error.path("message").asText(bodyText);
            } catch (Exception ignored) {
                reason = bodyText;
            }
            throw new IllegalStateException("OpenAI API error (" + response.statusCode() + "): " + reason);
        }

        JsonNode root = objectMapper.readTree(response.body());
        JsonNode choices = root.path("choices");
        if (!choices.isArray() || choices.isEmpty()) {
            return "[OpenAI] No content returned.";
        }
        String content = choices.get(0).path("message").path("content").asText("");
        if (content.isBlank()) {
            return "[OpenAI] No content returned.";
        }
        return content.trim();
    }
}
