package com.kfh.educationservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthenticationRequestDto {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
