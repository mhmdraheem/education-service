package com.kfh.educationservice.controller;

import com.kfh.educationservice.dto.StudentDto;
import com.kfh.educationservice.service.student.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto registerStudent(@Valid @RequestBody StudentDto studentDto) {
        return studentService.registerStudent(studentDto);
    }
}
