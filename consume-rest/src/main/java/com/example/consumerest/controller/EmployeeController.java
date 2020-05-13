package com.example.consumerest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumerest.model.Employee;
import com.example.consumerest.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "employees",method = RequestMethod.GET)   // or use @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
	
	@RequestMapping(value = "findEmployee",method = RequestMethod.GET)   // or use @GetMapping
    public Employee getEmployee(@RequestBody Employee emp) {
        return employeeService.getEmployee(emp);
    }
	
	@RequestMapping(value = "newEmployee",method = RequestMethod.POST)   // or use @GetMapping
    public String addEmployee(@RequestBody Employee emp) {
        return employeeService.addEmployee(emp);
    }

}
