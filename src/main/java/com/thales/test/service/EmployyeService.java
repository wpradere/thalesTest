package com.thales.test.service;

import com.thales.test.model.Dto.Employee;
import com.thales.test.model.Dto.EmployeeSalary;
import com.thales.test.model.Dto.ResponseEmployee;

import java.util.List;

public interface EmployyeService {
    List <Employee> getAll();
    List<EmployeeSalary> annualSalary();
    Employee getById(int id);
}
