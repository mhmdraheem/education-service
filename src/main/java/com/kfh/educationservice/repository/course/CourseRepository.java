package com.kfh.educationservice.repository.course;

import com.kfh.educationservice.entity.course.Course;
import com.kfh.educationservice.entity.course.CourseDetailsProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("""
            select
                c.name as courseName,
                c.description as courseDescription,
                c.price as coursePrice
            from Course c
            """)
    Page<CourseDetailsProjection> findCoursesPage(PageRequest pageRequest);
}
