package com.kfh.educationservice.controller;

import com.kfh.educationservice.dto.StudentCourseDto;
import com.kfh.educationservice.dto.UpdateStudentCoursesDto;
import com.kfh.educationservice.service.student.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
@Tag(name = "Student APIs", description = "A group of endpoints for managing students and their courses")
public class StudentController {

    private final StudentService studentService;

    @Operation(
            summary = "Lists each student with his corresponding course list",
            description = "An endpoint that is available for admins for displaying all students with all courses and it uses pagination")
    @Secured({"ROLE_ADMIN"})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Page<StudentCourseDto> listStudentsCourses(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "pageSize", defaultValue = "5") int pageSize) {
        return studentService.listStudentsCourses(pageNum, pageSize);
    }

    @Operation(
            summary = "Delete student by id",
            description = "An endpoint that is available for admins to delete a student by id")
    @Secured({"ROLE_ADMIN"})
    @DeleteMapping(path = "/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @Operation(
            summary = "Assign course to student",
            description = "An endpoint that is available for currently authenticated student to assign a course for himself")
    @Secured({"ROLE_STUDENT"})
    @PutMapping(path = "/course/{courseId}/assign")
    @ResponseStatus(HttpStatus.OK)
    public void assignCourseToStudent(@PathVariable Long courseId) {
        studentService.assignCourseToStudent(courseId);
    }

    @Operation(
            summary = "Update multiple student courses",
            description = "An endpoint that is available for currently authenticated student to update his course list")
    @Secured({"ROLE_STUDENT"})
    @PutMapping(path = "/course")
    @ResponseStatus(HttpStatus.OK)
    public void updateStudentCourses(@RequestBody UpdateStudentCoursesDto updateStudentCoursesDto) {
        studentService.updateStudentCourses(updateStudentCoursesDto);
    }
}
