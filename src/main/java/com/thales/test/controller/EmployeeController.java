package com.thales.test.controller;

import com.thales.test.model.Dto.Employee;
import com.thales.test.model.Dto.EmployeeSalary;
import com.thales.test.service.EmployeeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/data")
@Component
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }


@CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getUser(){
        return ResponseEntity.ok(employeeService.getAll());
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("salary")
    public ResponseEntity<List<EmployeeSalary>> getAnnualSalary(){
        return ResponseEntity.ok(employeeService.annualSalary());
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable("id") String id){
        return  ResponseEntity.ok(employeeService.getById(id));
    }
}
