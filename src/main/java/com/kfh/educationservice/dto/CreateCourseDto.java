package com.kfh.educationservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateCourseDto {

    @NotBlank
    private final String name;

    @NotNull
    private final BigDecimal price;

    @NotBlank
    private final String description;
}
