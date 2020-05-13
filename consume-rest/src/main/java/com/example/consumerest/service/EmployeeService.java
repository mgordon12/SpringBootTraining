package com.example.consumerest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.consumerest.model.Employee;

@Service
public class EmployeeService {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
//	public List<Employee> getAllEmployees() {
//		RestTemplate restTemplate = new RestTemplate();
//		List<Employee> employeeList = new ArrayList<Employee>();
//		ResponseEntity<Employee[]> response = restTemplate.getForEntity("http://localhost:8080/listEmployees", Employee[].class);
//		Employee[] employees = response.getBody();
//		employeeList = Arrays.asList(employees);
//		for (Employee emp : employees) {
//			log.info(emp.toString());
//		}
//		return employeeList;
//
//	}
	
	public List<Employee> getAllEmployees() {
		RestTemplate restTemplate = new RestTemplate();
		List<Employee> employeeList = new ArrayList<Employee>();
		Employee[] employees = restTemplate.getForObject("http://localhost:8080/listEmployees", Employee[].class);
		employeeList = Arrays.asList(employees);
		for (Employee emp : employees) {
			log.info(emp.toString());
		}
		return employeeList;

	}
	
	// using exchange 
	public Employee getEmployee(Employee emp) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Employee> request = new HttpEntity<>(emp);
		String empNo = emp.getEmployeeId();
		ResponseEntity<Employee> response = restTemplate.exchange("http://localhost:8080/Employee/{empNo}", HttpMethod.GET,request,Employee.class,empNo);
		return response.getBody();
	}
	
	// using post for entity
	public String addEmployee(Employee emp) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Employee> response = restTemplate.postForEntity("http://localhost:8080/newEmployee/", emp, Employee.class);
		return emp.getEmployeeId() + " has been added";
	}
	

}
