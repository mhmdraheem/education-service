package com.kfh.educationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDto {
    private String code;
    private String message;
}
