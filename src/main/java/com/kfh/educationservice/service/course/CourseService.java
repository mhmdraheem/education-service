package com.kfh.educationservice.service.course;

import com.kfh.educationservice.common.exception.type.CourseNotFoundException;
import com.kfh.educationservice.common.exception.type.DuplicateCourseException;
import com.kfh.educationservice.dto.CourseDto;
import com.kfh.educationservice.entity.course.Course;
import com.kfh.educationservice.repository.course.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Page<CourseDto> listCourses(int pageNum, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize);
        Page<Course> coursesPage = courseRepository.findAll(pageRequest);
        return coursesPage.map(this::courseEntityToDto);
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
    public CourseDto createCourse(CourseDto courseDto) {
        validateCourseDoesNotExist(courseDto);
        Course course = populateCourseEntity(new Course(), courseDto);
        courseRepository.save(course);
        return courseEntityToDto(course);
    }

    private void validateCourseDoesNotExist(CourseDto courseDto) {
        if(courseRepository.existsByName(courseDto.getName())) {
            throw new DuplicateCourseException(courseDto.getName());
        }
    }

    private Course populateCourseEntity(Course course, CourseDto courseDto) {
        course.setName(courseDto.getName());
        course.setDescription(courseDto.getDescription());
        course.setPrice(courseDto.getPrice());
        return course;
    }

    @Transactional
    public void updateCourse(Long id, CourseDto courseDto) {
        Course course = getCourseById(id);
        populateCourseEntity(course, courseDto);
    }

    public Course getCourseById(Long id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if(courseOptional.isEmpty()) {
            throw new CourseNotFoundException(String.valueOf(id));
        }

        return courseOptional.get();
    }

    @Transactional
    public void deleteCourse(Long courseId) {
        Course course = getCourseById(courseId);
        courseRepository.delete(course);
    }

    public Set<Course> getCoursesByIdIn(Set<Long> coursesIds) {
        return courseRepository.findByIdIn(coursesIds);
    }
}
