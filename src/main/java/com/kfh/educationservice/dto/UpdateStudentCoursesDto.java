package com.kfh.educationservice.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UpdateStudentCoursesDto {
    private Set<Long> coursesIds;
}
