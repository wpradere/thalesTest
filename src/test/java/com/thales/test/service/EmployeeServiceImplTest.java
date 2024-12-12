package com.thales.test.service;

import com.thales.test.model.Dto.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeServiceImplTest {


    @MockBean
    private EmployeeServiceImpl employeeServiceMock;



@BeforeEach
    void setUp() {

    Employee employee = new Employee();

    employee.setId("2");
    employee.setEmployeeName("Matt Cronin");
    employee.setEmployeeSalary("876.00");
    employee.setEmployeeAge(68);
    employee.setProfileImage("");


    Mockito.when(employeeServiceMock.getById("2")).thenReturn(Optional.of(employee));

}
@Test
    public void testFindById() {
    var employee = employeeServiceMock.getById("2");

    assertNotNull(employee);
    assertEquals("Matt Cronin", employee.get().getEmployeeName());
    assertEquals("876.00", employee.get().getEmployeeSalary());

}

}