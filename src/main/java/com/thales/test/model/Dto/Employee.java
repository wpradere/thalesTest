package com.thales.test.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    String id;
    String employee_name;
    Integer employee_salary;
    int employee_age;
    String profile_image;
}
