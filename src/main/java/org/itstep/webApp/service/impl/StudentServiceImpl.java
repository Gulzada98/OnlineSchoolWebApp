package org.itstep.webApp.service.impl;

import org.itstep.webApp.entity.Group;
import org.itstep.webApp.entity.Student;
import org.itstep.webApp.repository.StudentRepo;
import org.itstep.webApp.service.StudentService;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
/*@EnableWebSecurity*/
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Student findByEmail(String email) {
        return studentRepo.findByEmail(email);
    }

    @Override
    public void addNewStudent(Student student) {
        Student checkStudent = studentRepo.findByEmail(student.getEmail());

        if (checkStudent == null){
            studentRepo.save(student);
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public List<Student> getStudentsByGroup(Group group) {
        return studentRepo.getStudentsByGroup(group);
    }

   /* @Override
    public List<Student> getStudentsByGroup_Id(Long groupId) {
        return studentRepo.getStudentsByGroup_Id(groupId);
    }*/


    @Override
    public void updateStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepo.deleteById(id);
    }
}
