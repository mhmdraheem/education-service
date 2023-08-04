package com.kfh.educationservice.controller;

import com.kfh.educationservice.dto.CourseDto;
import com.kfh.educationservice.service.course.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
@Tag(name = "Courses APIs", description = "A group of endpoints for displaying and manipulating courses")
public class CourseController {

    private final CourseService courseService;

    @Operation(
            summary = "Lists courses",
            description = "A public endpoint that returns a list of all available course and uses pagination")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Page<CourseDto> listCourses(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
                                       @RequestParam(name = "pageSize", defaultValue = "5") int pageSize) {
        return courseService.listCourses(pageNum, pageSize);
    }

    @Operation(
            summary = "create course",
            description = "An endpoint that creates a new course if no one with same name exists")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDto createCourse(@Valid @RequestBody CourseDto courseDto) {
        return courseService.createCourse(courseDto);
    }

    @Operation(
            summary = "Update course by it's id",
            description = "An endpoint that updates a course by id")
    @PutMapping(path = "/{courseId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateCourse(@PathVariable Long courseId, @Valid @RequestBody CourseDto courseDto) {
        courseService.updateCourse(courseId, courseDto);
    }

    @Operation(
            summary = "Delete course by it's id",
            description = "An endpoint that deletes a course by id")
    @DeleteMapping(path = "/{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable Long courseId) {
        courseService.deleteCourse(courseId);
    }
}
