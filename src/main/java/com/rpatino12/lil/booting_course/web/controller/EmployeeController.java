package com.rpatino12.lil.booting_course.web.controller;

import com.rpatino12.lil.booting_course.data.entity.EmployeeEntity;
import com.rpatino12.lil.booting_course.data.entity.RoomEntity;
import com.rpatino12.lil.booting_course.data.repository.EmployeeRepository;
import com.rpatino12.lil.booting_course.web.model.Employee;
import com.rpatino12.lil.booting_course.web.model.Room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public String getEmployeesPage(Model model){
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>(employeeEntities.size());
        employeeEntities.forEach(e -> employees.add(
                new Employee(e.getEmployeeId(), e.getFirstName(), e.getLastName(), e.getPosition().toString())));
        employees.sort(Comparator.comparing(Employee::getPosition));
        model.addAttribute("employees", employees);
        return "employees";
    }
}
