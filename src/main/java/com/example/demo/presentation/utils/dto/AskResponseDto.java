package com.example.demo.presentation.utils.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AskResponseDto {
    private List<AiResponseDto> aiResponses;
}
