package org.itstep.webApp.service;

import org.itstep.webApp.entity.Employee;
import org.itstep.webApp.entity.Student;

import java.util.List;

public interface EmployeeService {
    Employee findByEmail(String email);

    void addNewEmployee(Employee employee);

    List<Employee> getAllEmployees();

    void updateEmployee(Employee employee);
    void deleteEmployeeById(Long id);
}
