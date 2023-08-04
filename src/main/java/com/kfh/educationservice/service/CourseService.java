package com.kfh.educationservice.service;

import com.kfh.educationservice.dto.CourseDto;
import com.kfh.educationservice.dto.InstructorDto;
import com.kfh.educationservice.entity.course.CourseDetailsProjection;
import com.kfh.educationservice.repository.course.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Page<CourseDto> listCourses(int pageNum, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize);
        Page<CourseDetailsProjection> coursesPage = courseRepository.findCoursesPage(pageRequest);
        return coursesPage.map(this::createCourseDto);
    }

    private CourseDto createCourseDto(CourseDetailsProjection projection) {
        InstructorDto instructorDto = InstructorDto.builder()
                .englishName(projection.getInstructorName())
                .email(projection.getInstructorEmail())
                .telephone(projection.getInstructorPhone())
                .build();

        return CourseDto.builder()
                .name(projection.getCourseName())
                .price(projection.getCoursePrice())
                .description(projection.getCourseDescription())
                .instructor(instructorDto)
                .build();
    }
}
