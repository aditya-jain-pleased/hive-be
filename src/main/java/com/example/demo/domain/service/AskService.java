package com.example.demo.domain.service;

import com.example.demo.domain.ai.AiAdapter;
import com.example.demo.domain.ai.AiAdapterFactory;
import com.example.demo.presentation.utils.dto.AiResponseDto;
import com.example.demo.presentation.utils.dto.AskResponseDto;
import com.example.demo.util.command.AskQuestionCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AskService {

    private final AiAdapterFactory aiAdapterFactory;

    public AskResponseDto ask(AskQuestionCommand command) {
        ArrayList<AiResponseDto> responses = new ArrayList<>();

        for (AiAdapter adapter : aiAdapterFactory.getAllAdapters()) {
            String answer;
            try {
                answer = adapter.ask(command.getQuestion());
            } catch (Exception ex) {
                answer = "ERROR: " + ex.getMessage();
            }

            responses.add(
                    AiResponseDto.builder()
                            .aiName(adapter.getName())
                            .answer(answer)
                            .build()
            );

        }

        return AskResponseDto.builder()
                .aiResponses(responses)
                .build();
    }
}
