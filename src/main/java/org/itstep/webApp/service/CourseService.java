package org.itstep.webApp.service;

import org.itstep.webApp.entity.Course;
import org.itstep.webApp.entity.Group;

import java.util.List;

public interface CourseService {

    void addNewCourse(Course course);

    List<Course> getAllCourses();
    Course getCourse(Long id);

    void updateCourse(Course course);
    void deleteCourseById(Long id);
}
