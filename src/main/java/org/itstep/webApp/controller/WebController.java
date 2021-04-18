package org.itstep.webApp.controller;

import lombok.extern.slf4j.Slf4j;
import org.itstep.webApp.entity.*;
import org.itstep.webApp.service.*;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class WebController {

    private final EmployeeService employeeService;
    private final StudentService studentService;
    private final GroupService groupService;
    private final CourseService courseService;
    private final RoleService roleService;

    public WebController(EmployeeService employeeService, StudentService studentService, GroupService groupService, CourseService courseService, RoleService roleService) {
        this.employeeService = employeeService;
        this.studentService = studentService;
        this.groupService = groupService;
        this.courseService = courseService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/login") public String login(Model model) {

        model.addAttribute("currentUser", getUser());
        return "login";
    }

    @GetMapping(value = "/getStudents")
    public String getAllStudents(Model model) {
        List<Student> allStudents = studentService.getAllStudents();
        List<Group> allGroups = groupService.getAllGroups();
        model.addAttribute("students", allStudents);
        model.addAttribute("groups", allGroups);

        return "student";
    }

    /*@PreAuthorize("hasAnyRole('ROLE_MODERATOR', 'ROLE_ADMIN')")*/
    @PostMapping(value = "/addStudent")
    public String addStudent(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "fullName") String fullName,
            @RequestParam(name = "password") String password,
            /*@RequestParam(name = "photo") String photo,*/
            @RequestParam(name = "groupId") Long groupId
    ) {
        Student student = new Student();
        Group group = groupService.getGroup(groupId);

        student.setEmail(email);
        student.setFullName(fullName);
        student.setPassword(password);
        student.setPhoto("img2.jpg");
        student.setGroup(group);
        studentService.addNewStudent(student);
        return "redirect:/getStudents";
    }

    /*@PreAuthorize("hasRole('ROLE_ADMIN')")*/
    @PostMapping(value = "/deleteStudent")
    public String deleteStudent(
            @RequestParam(name = "studentId") Long studentId
    ) {
        studentService.deleteStudentById(studentId);
        return "redirect:/getStudents";
    }

//    Employee ==============================================================
@GetMapping(value = "/getEmployees")
public String getAllTeachers(Model model) {
    List<Employee> allEmployees = employeeService.getAllEmployees();
    List<Course> allCourses = courseService.getAllCourses();
    model.addAttribute("employees", allEmployees);
    model.addAttribute("courses", allCourses);

    return "employee";
}

    /*@PreAuthorize("hasAnyRole('ROLE_MODERATOR', 'ROLE_ADMIN')")*/
    @PostMapping(value = "/addTeacher")
    public String addTeacher(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "fullName") String fullName,
            @RequestParam(name = "password") String password,
            /*@RequestParam(name = "photo") String photo,*/
            @RequestParam(name = "courseId") Long courseId
    ) {
        Employee employee = new Employee();
        Role role = roleService.getRole(2L);
        Course course = courseService.getCourse(courseId);
        List<Course> courses = new ArrayList<>();
        courses.add(course);

        employee.setEmail(email);
        employee.setFullName(fullName);
        employee.setPassword(password);
        employee.setPhoto("img1.jpg");
        employee.setRole(role);
        employee.setCourses(courses);
        employeeService.addNewEmployee(employee);
        return "redirect:/getEmployees";
    }

    /*@PreAuthorize("hasRole('ROLE_ADMIN')")*/
    @PostMapping(value = "/deleteEmployee")
    public String deleteEmployee(
            @RequestParam(name = "employeeId") Long employeeId
    ) {
        employeeService.deleteEmployeeById(employeeId);
        return "redirect:/getEmployees";
    }

    /*@PreAuthorize("hasRole('ROLE_TEACHER')")*/
    @GetMapping(value = "/myStudents")
    public String getMyStudents(Model model){
        /*Employee employee = (Employee) getUser();*/


        List<Group> allGroups = groupService.getAllGroups();
        List<Group> selectedGroups = new ArrayList<>();
        List<Student> selectedStudents = new ArrayList<>();
        List<List<Student>> test = new ArrayList<>();
        for (Group group: allGroups) {
            if(group.getEmployee().getId()==4L/*employee.getId()*/){
                selectedGroups.add(group);
                selectedStudents = studentService.getStudentsByGroup(group);
                test.add(selectedStudents);
            }

        }
        model.addAttribute("selectedGroups", selectedGroups);
        model.addAttribute("selectedStudents", test);
        return  "myStudents";
    }

    private Object getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User user = (User) authentication.getPrincipal();
            Object myUser = employeeService.findByEmail(user.getUsername());
            if (myUser==null){
                myUser = studentService.findByEmail(user.getUsername());
            }
            return myUser;
        }
        return null;
    }

}
