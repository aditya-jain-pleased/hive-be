package com.example.demo.domain.service;

import com.example.demo.util.command.AskQuestionCommand;
import org.springframework.stereotype.Service;
import com.example.demo.presentation.utils.dto.AskResponseDto;

@Service
public class AskService {

    // Factory -> Adapter
//    private OpenAiClient
//    private GeminiClient
//            ...

    public AskResponseDto ask(AskQuestionCommand command) {
        // do logic
        // Factory pattern to get all adapters
        // Create the factory
        // Create the Adapter interface
        //  List<Adapter> get....
        // for each adapter, you call the "ask" method and you get an "answer"
        // get the AI's to call
        // for each one, make the call and add it to the result
        // return the consolidated DTO object
        return null;
    }
}
