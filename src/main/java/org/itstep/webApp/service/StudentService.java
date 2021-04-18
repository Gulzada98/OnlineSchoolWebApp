package org.itstep.webApp.service;

import org.itstep.webApp.entity.Group;
import org.itstep.webApp.entity.Student;

import java.util.List;

public interface StudentService {
    Student findByEmail(String email);

    void addNewStudent(Student student);

    List<Student> getAllStudents();
    //List<Student> getStudentsByGroup_Id(Long group_id);
    List<Student> getStudentsByGroup(Group group);

    void updateStudent(Student student);
    void deleteStudentById(Long id);
}
