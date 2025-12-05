package com.example.demo.domain.ai.impl;

import com.example.demo.domain.ai.AiAdapter;
import org.springframework.stereotype.Component;

@Component
public class GeminiMockAdapter implements AiAdapter {
    @Override
    public String getName() {
        return "Gemini";
    }

    @Override
    public String ask(String question) {
        // Mocked response; replace with real client integration later
        return "[Gemini] " + "Answer to: " + question;
    }
}
