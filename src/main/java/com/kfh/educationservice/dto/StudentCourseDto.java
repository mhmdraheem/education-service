package com.kfh.educationservice.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentCourseDto {
    private Long id;
    private String email;
    private List<CourseDto> courses;
}
