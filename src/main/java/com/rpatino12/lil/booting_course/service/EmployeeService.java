package com.rpatino12.lil.booting_course.service;

import com.rpatino12.lil.booting_course.data.entity.EmployeeEntity;
import com.rpatino12.lil.booting_course.data.entity.Position;
import com.rpatino12.lil.booting_course.data.repository.EmployeeRepository;
import com.rpatino12.lil.booting_course.web.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>(employeeEntities.size());
        employeeEntities.forEach(e -> employees.add(entityToEmployee(e)));
        return employees;
    }

    public Employee getEmployeeById(UUID id){
        Optional<EmployeeEntity> entity = employeeRepository.findById(id);
        if (entity.isEmpty()){
            return null;
        } else {
            return entityToEmployee(entity.get());
        }
    }

    public Employee addEmployee(Employee employee){
        EmployeeEntity entity = employeeToEntity(employee);
        entity = employeeRepository.save(entity);
        return entityToEmployee(entity);
    }

    public Employee updateEmployee(UUID id, Employee newEmployee){
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            EmployeeEntity entity = employeeToEntity(newEmployee);
            entity = employeeRepository.save(entity);
            return entityToEmployee(entity);
        } else {
            return null;
        }
    }

    public void deleteEmployee(UUID id){
        this.employeeRepository.deleteById(id);
    }

    private Employee entityToEmployee(EmployeeEntity entity){
        return new Employee(entity.getEmployeeId(), entity.getFirstName(), entity.getLastName(), entity.getPosition().toString());
    }

    private EmployeeEntity employeeToEntity(Employee employee){
        EmployeeEntity entity = new EmployeeEntity();
        entity.setEmployeeId(employee.getId());
        entity.setFirstName(employee.getFirstName());
        entity.setLastName(employee.getLastName());
        entity.setPosition(Position.valueOf(employee.getPosition()));
        return entity;
    }
}
