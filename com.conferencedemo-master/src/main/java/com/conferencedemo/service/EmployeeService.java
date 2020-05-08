package com.conferencedemo.service;

import java.util.List;

import com.conferencedemo.model.Employee;

public interface EmployeeService {
	List<Employee> findAll();
	Employee findById(String empNo);
	void deleteById(String empNo);
	Employee save(Employee emp);
}
