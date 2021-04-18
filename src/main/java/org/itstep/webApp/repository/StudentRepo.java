package org.itstep.webApp.repository;

import org.itstep.webApp.entity.Group;
import org.itstep.webApp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findByEmail(String email);

    //List<Student> getStudentsByGroup_Id(Long groupId);
    List<Student> getStudentsByGroup(Group group);

}

