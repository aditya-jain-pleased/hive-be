package com.example.demo.domain.ai;

/**
 * Contract for any AI provider adapter.
 */
public interface AiAdapter {
    /**
     * Human-readable provider name (e.g., "OpenAI", "Gemini").
     */
    String getName();

    /**
     * Ask the provider a question and return its answer as plain text.
     */
    String ask(String question) throws Exception;
}
