package com.kfh.educationservice.controller;

import com.kfh.educationservice.dto.StudentCourseDto;
import com.kfh.educationservice.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
@Secured({"ROLE_STUDENT"})
public class StudentController {

    private final StudentService studentService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Page<StudentCourseDto> listStudentsCourses(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "pageSize", defaultValue = "5") int pageSize) {
        return studentService.listStudentsCourses(pageNum, pageSize);
    }
}
