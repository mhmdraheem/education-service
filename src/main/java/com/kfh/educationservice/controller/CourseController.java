package com.kfh.educationservice.controller;

import com.kfh.educationservice.dto.CourseDto;
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
    public CourseDto createCourse(@Valid @RequestBody CourseDto courseDto) {
        return courseService.createCourse(courseDto);
    }

    @PutMapping(path = "/{courseId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateCourse(@PathVariable Long courseId, @Valid @RequestBody CourseDto courseDto) {
        courseService.updateCourse(courseId, courseDto);
    }

    @DeleteMapping(path = "/{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable Long courseId) {
        courseService.deleteCourse(courseId);
    }
}
