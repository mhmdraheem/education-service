package com.kfh.educationservice.controller;

import com.kfh.educationservice.dto.CourseDto;
import com.kfh.educationservice.dto.CreateCourseDto;
import com.kfh.educationservice.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Page<CourseDto> listCourses(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
                                       @RequestParam(name = "pageSize", defaultValue = "5") int pageSize) {
        return courseService.listCourses(pageNum, pageSize);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createCourse(@Valid @RequestBody CreateCourseDto createCourseDto) {
        courseService.createCourse(createCourseDto);
    }
}
