package com.thales.test.controller;

import com.thales.test.model.Dto.Employee;
import com.thales.test.model.Dto.EmployeeSalary;
import com.thales.test.model.Dto.ResponseEmployee;
import com.thales.test.service.EmployeeServiceImpl;
import com.thales.test.service.EmployyeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data")
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
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id){
        return  ResponseEntity.ok(employeeService.getById(id));
    }
}
