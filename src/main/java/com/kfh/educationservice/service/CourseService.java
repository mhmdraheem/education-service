package com.kfh.educationservice.service;

import com.kfh.educationservice.common.exception.type.DuplicateCourseException;
import com.kfh.educationservice.dto.CourseDto;
import com.kfh.educationservice.dto.CreateCourseDto;
import com.kfh.educationservice.entity.course.Course;
import com.kfh.educationservice.entity.course.CourseDetailsProjection;
import com.kfh.educationservice.repository.course.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return CourseDto.builder()
                .name(projection.getCourseName())
                .price(projection.getCoursePrice())
                .description(projection.getCourseDescription())
                .build();
    }

    @Transactional
    public void createCourse(CreateCourseDto courseDto) {
        validateCourseDoesNotExist(courseDto);
        Course course = createCourseEntity(courseDto);
        courseRepository.save(course);
    }

    private void validateCourseDoesNotExist(CreateCourseDto courseDto) {
        if(courseRepository.existsByName(courseDto.getName())) {
            throw new DuplicateCourseException(courseDto.getName());
        }
    }

    private Course createCourseEntity(CreateCourseDto courseDto) {
        Course course = new Course();
        course.setName(courseDto.getName());
        course.setDescription(courseDto.getDescription());
        course.setPrice(courseDto.getPrice());
        return course;
    }
}
