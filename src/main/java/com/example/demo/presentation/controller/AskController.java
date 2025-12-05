package com.example.demo.presentation.controller;

import com.example.demo.domain.service.AskService;
import com.example.demo.util.command.AskQuestionCommand;
import com.example.demo.util.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.presentation.utils.dto.AskResponseDto;

@RestController
@RequiredArgsConstructor
public class AskController {

    private final AskService askService;

    @PostMapping("/ask")
    public BaseResponse<AskResponseDto> ask(
            @RequestHeader(name ="userId") String userId,
            @RequestBody AskQuestionCommand askQuestionCommand) throws Exception {
        // do validations about the input data
        // for example, the question in the command is not empty
        AskResponseDto dto = askService.ask(askQuestionCommand);
        BaseResponse<AskResponseDto> result = BaseResponse.<AskResponseDto>builder()
                .code(1000) // success
                .data(dto)
                .build();
        return result;
    }

    // PRE
    // EXC
    // POST
}
