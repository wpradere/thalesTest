package com.thales.test.model.Dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
public class Employee {
    @JsonProperty("id")
    private String id;

    @JsonProperty("employee_name")
    private String employeeName;

    @JsonProperty("employee_salary")
    private String employeeSalary;

    @JsonProperty("employee_age")
    private int employeeAge;

    @JsonProperty("profile_image")
    private String profileImage;


}
