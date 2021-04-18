package org.itstep.webApp.service.impl;

import org.itstep.webApp.entity.Employee;
import org.itstep.webApp.repository.EmployeeRepo;
import org.itstep.webApp.service.EmployeeService;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
/*@EnableWebSecurity*/
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeRepo.findByEmail(email);
    }

    @Override
    public void addNewEmployee(Employee employee) {
        Employee checkEmployee = employeeRepo.findByEmail(employee.getEmail());
        if(checkEmployee == null){
            employeeRepo.save(employee);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepo.deleteById(id);
    }
}
