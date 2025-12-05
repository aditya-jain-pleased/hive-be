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
    private String question;
    // add more fields

    public void validate() throws Exception {
        if (question == null || question.isBlank()) {
            throw new Exception();
        }
    }
}
