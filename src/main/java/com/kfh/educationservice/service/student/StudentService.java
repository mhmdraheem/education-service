package com.kfh.educationservice.service.student;

import com.kfh.educationservice.dto.CourseDto;
import com.kfh.educationservice.dto.StudentCourseDto;
import com.kfh.educationservice.entity.course.Course;
import com.kfh.educationservice.entity.user.User;
import com.kfh.educationservice.repository.user.UserRepository;
import com.kfh.educationservice.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final UserService userService;
    private final UserRepository userRepository;

    public Page<StudentCourseDto> listStudentsCourses(int pageNum, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize);
        Page<User> students = userRepository.findStudentsCourses(pageRequest);
        return students.map(this::map);
    }

    private StudentCourseDto map(User user) {
        List<CourseDto> courses =
                user.getCourses().stream().map(this::courseEntityToDto).toList();

        StudentCourseDto studentCourseDto = new StudentCourseDto();
        studentCourseDto.setId(user.getId());
        studentCourseDto.setEmail(user.getEmail());
        studentCourseDto.setCourses(courses);
        return studentCourseDto;
    }

    private CourseDto courseEntityToDto(Course course) {
        return CourseDto.builder()
                .id(course.getId())
                .name(course.getName())
                .price(course.getPrice())
                .description(course.getDescription())
                .build();
    }

    @Transactional
    public void deleteStudent(Long studentId) {
        userService.validateUserExists(studentId);
        userRepository.deleteById(studentId);
    }
}
