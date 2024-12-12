package com.thales.test.service;

import com.thales.test.model.Dto.Employee;
import com.thales.test.model.Dto.EmployeeSalary;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List <Employee> getAll();
    List<EmployeeSalary> annualSalary();
    Optional<Employee> getById(String id);
}
