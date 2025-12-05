package com.example.demo.util.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AskQuestionCommand {
    private static final int MAX_QUESTION_LENGTH = 1000;

    private String question;
    // add more fields

    public void validate() throws Exception {
        if (question == null) {
            throw new Exception("question is required");
        }

        String normalized = question.trim();
        if (normalized.isEmpty()) {
            throw new Exception("question must not be blank");
        }

        if (normalized.length() > MAX_QUESTION_LENGTH) {
            throw new Exception("question must be at most " + MAX_QUESTION_LENGTH + " characters");
        }

        // persist normalized value
        this.question = normalized;
    }
}
