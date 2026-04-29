package com.stackly.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.stackly.ems.dto.EmployeeDTO;
import com.stackly.ems.entity.Employee;
import com.stackly.ems.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @PostMapping
    public Employee create(@RequestBody EmployeeDTO dto) {

        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setEmail(dto.getEmail());
        emp.setDepartment(dto.getDepartment());
        emp.setSalary(dto.getSalary());

        return service.saveEmployee(emp);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee emp) {
        return service.updateEmployee(id, emp);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "Employee deleted successfully";
    }
}