package org.itstep.webApp.repository;

import org.itstep.webApp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CourseRepo extends JpaRepository<Course, Long>{
    Course findByCourseName(String name);
}
