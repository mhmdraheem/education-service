package com.kfh.educationservice.repository.course;

import com.kfh.educationservice.entity.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    boolean existsByName(String courseName);

    Set<Course> findByIdIn(Set<Long> coursesIds);
}
