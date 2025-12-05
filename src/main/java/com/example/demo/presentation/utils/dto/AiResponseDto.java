package com.example.demo.presentation.utils.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AiResponseDto {
    private String answer;
    private String aiName;
}
