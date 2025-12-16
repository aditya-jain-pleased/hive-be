package com.example.demo.domain.ai.impl;

import com.example.demo.domain.ai.AiAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

@Component
public class GeminiAiAdapter implements AiAdapter {

    @Value("${gemini.api.key:}")
    private String apiKey;


    @Override
    public String getName() {
        return "Gemini";
    }

    @Override
    public String ask(String question) {
        // The client gets the API key from the environment variable `GEMINI_API_KEY`.
        Client client = Client.builder().apiKey(apiKey).build();

        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-2.5-flash",
                        question,
                        null);

        System.out.println(response.text());

        return response.text();
    }
}
