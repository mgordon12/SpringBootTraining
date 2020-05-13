package com.conferencedemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conferencedemo.model.Employee;
import com.conferencedemo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	public Employee findById(String empNo) {
		return employeeRepository.findById(empNo).get();
	}
	
	public void deleteById(String empNo) {
		employeeRepository.deleteById(empNo);
	}
	
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}

}
