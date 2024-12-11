package com.thales.test.model.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ResponseEmployee {
private String status;
private String message;
@JsonProperty("data")
private List<Employee> employee;
}
