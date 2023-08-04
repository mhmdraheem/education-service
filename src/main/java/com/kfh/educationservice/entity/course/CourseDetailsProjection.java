package com.kfh.educationservice.entity.course;

import java.math.BigDecimal;

public interface CourseDetailsProjection {
    String getCourseName();
    String getCourseDescription();
    BigDecimal getCoursePrice();
    String getInstructorName();
    String getInstructorEmail();
    String getInstructorPhone();
}
