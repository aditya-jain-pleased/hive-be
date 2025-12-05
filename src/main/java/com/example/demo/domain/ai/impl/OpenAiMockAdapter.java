package com.example.demo.domain.ai.impl;

import com.example.demo.domain.ai.AiAdapter;
import org.springframework.stereotype.Component;

@Component
public class OpenAiMockAdapter implements AiAdapter {
    @Override
    public String getName() {
        return "OpenAI";
    }

    @Override
    public String ask(String question) {
        // Mocked response; replace with real client integration later
        return "[OpenAI] " + "Answer to: " + question;
    }
}
