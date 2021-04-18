package org.itstep.webApp.service.impl;

import org.itstep.webApp.entity.Course;
import org.itstep.webApp.repository.CourseRepo;
import org.itstep.webApp.service.CourseService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;

    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public void addNewCourse(Course course) {
        Course checkCourse = courseRepo.findByCourseName(course.getCourseName());
        if (checkCourse == null) {
            courseRepo.save(course);
        }
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Course getCourse(Long id) {
        return courseRepo.getOne(id);
    }

    @Override
    public void updateCourse(Course course) {
        courseRepo.save(course);
    }

    @Override
    public void deleteCourseById(Long id) {
        courseRepo.deleteById(id);
    }
}
