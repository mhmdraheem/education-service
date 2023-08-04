package com.kfh.educationservice.repository.course;

import com.kfh.educationservice.entity.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    boolean existsByName(String courseName);
    Optional<Course> findByName(String courseName);
}
