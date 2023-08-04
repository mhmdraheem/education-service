package com.kfh.educationservice.controller;

import com.kfh.educationservice.dto.StudentCourseDto;
import com.kfh.educationservice.dto.UpdateStudentCoursesDto;
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
public class StudentController {

    private final StudentService studentService;

    @Secured({"ROLE_ADMIN"})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Page<StudentCourseDto> listStudentsCourses(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "pageSize", defaultValue = "5") int pageSize) {
        return studentService.listStudentsCourses(pageNum, pageSize);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping(path = "/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @Secured({"ROLE_STUDENT"})
    @PutMapping(path = "/course/{courseId}/assign")
    @ResponseStatus(HttpStatus.OK)
    public void assignCourseToStudent(@PathVariable Long courseId) {
        studentService.assignCourseToStudent(courseId);
    }

    @Secured({"ROLE_STUDENT"})
    @PutMapping(path = "/course")
    @ResponseStatus(HttpStatus.OK)
    public void updateStudentCourses(@RequestBody UpdateStudentCoursesDto updateStudentCoursesDto) {
        studentService.updateStudentCourses(updateStudentCoursesDto);
    }
}
