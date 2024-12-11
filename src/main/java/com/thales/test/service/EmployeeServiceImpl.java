package com.thales.test.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thales.test.model.Dto.Employee;
import com.thales.test.model.Dto.EmployeeSalary;
import com.thales.test.model.Dto.ResponseEmployee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployeeServiceImpl extends AbstractEmployee implements EmployyeService{

    public List<Employee> callServices(){
        List<Employee> employeesList = null;
        String uri = baseUrl;
        HttpEntity<Void> requestEntity = new HttpEntity<>(this.headersAdd());
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<Object> response = restTemplate.getForEntity(uri,Object.class);
        try {
            employeesList = objectMapper.convertValue(response.getBody(), new TypeReference<List<Employee>>(){});
            System.out.println(employeesList.get(0).getEmployeeName());

        }catch (Exception e){
            System.out.println("Error al mapear la respuesta a empleados   " + e);
        }
        return employeesList;
    }

    public EmployeeServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public List<Employee> getAll() {
        return callServices();
    }

    @Override
    public List<EmployeeSalary> annualSalary() {
        List<Employee> employeeList = callServices();

        List<EmployeeSalary>employeeSalary = employeeList.stream()
                .map(employee -> {
                    Double salary = 12* (Double.parseDouble( employee.getEmployeeSalary()));

                    return EmployeeSalary.builder()
                            .employeeName(employee.getEmployeeName())
                            .employeeAge(employee.getEmployeeAge())
                            .employeeSalary(salary)
                            .profileImage(employee.getProfileImage())
                            .id(employee.getId())
                            .build();

                })
                .collect(Collectors.toList());

        employeeSalary.forEach(employee -> {
            System.out.println(employee.getEmployeeSalary());
        });

        return employeeSalary;
    }

    @Override
    public Employee getById(int id) {
        Employee employee = null;
        String uri = baseUrl+"/"+id;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            ResponseEntity<Object> response = restTemplate.getForEntity(uri,Object.class);
            employee = objectMapper.convertValue(response.getBody(), new TypeReference<Employee>(){});

        }catch (Exception e){
            System.out.println("Error al mapear la respuesta a empleados  o el empleado no existe ");
        }
        return employee;
    }


}
