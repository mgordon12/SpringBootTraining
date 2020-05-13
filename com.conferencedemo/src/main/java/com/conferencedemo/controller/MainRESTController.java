package com.conferencedemo.controller;

import java.util.List;

import com.conferencedemo.dao.EmployeeDAO;
import com.conferencedemo.model.Employee;
import com.conferencedemo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRESTController {

//	@Autowired
//	private EmployeeDAO employeeDAO;

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/")
	public String welcome() {
		return "Welcome to RestTemplate Demo.";
	}

	// get all employee
	// URL - http://localhost:8080/listEmployees
	@RequestMapping(value = "listEmployees", method = RequestMethod.GET) // or use @GetMapping
	public java.util.List<Employee> listEmployees() {
		return employeeService.findAll();
	}
	
	// get one employee
	// URL - http://localhost:8080/Employee/{empNo}
	@RequestMapping(value = "Employee/{empNo}", method = RequestMethod.GET) // or use @GetMapping 
	public Employee getEmployee(@PathVariable("empNo") String empNo) { 
		return employeeService.findById(empNo); 
	}
	
	// delete employee
	// URL - http://localhost:8080/Employee/{empNo}
	@RequestMapping(value = "Employee/{empNo}", method = RequestMethod.DELETE) // or use @GetMapping 
	public String deleteEmployee(@PathVariable("empNo") String empNo) { 
		employeeService.deleteById(empNo); 
		return "Deleted employee " + empNo;
	}
	
	// create employee
	// URL - http://localhost:8080/newEmployee
	@RequestMapping(value = "newEmployee", method = RequestMethod.POST) // or use @GetMapping 
	public Employee createEmployee(@RequestBody Employee emp) { 
		return employeeService.save(emp); 
	}
	
	// update employee
	// URL - http://localhost:8080/Employee/{empNo}
	@RequestMapping(value = "Employee/{empNo}", method = RequestMethod.PUT) // or use @GetMapping 
	public Employee updateEmployee(@RequestBody Employee emp) { 
		return employeeService.save(emp); 
	}
	 
	
	  // URL - http://localhost:8080/employees
	  
	/*
	 * @RequestMapping(value = "/employees", // method = RequestMethod.GET, //
	 * produces = { MediaType.APPLICATION_JSON_VALUE }) public List<Employee>
	 * getEmployees() { List<Employee> list = employeeDAO.getAllEmployees(); return
	 * list; }
	 * 
	 * // URL - http://localhost:8080/employee/{empNo}
	 * 
	 * @RequestMapping(value = "/employee/{empNo}", // method = RequestMethod.GET,
	 * // produces = { MediaType.APPLICATION_JSON_VALUE }) public Employee
	 * getEmployee(@PathVariable("empNo") String empNo) { return
	 * employeeDAO.getEmployee(empNo); }
	 * 
	 * // URL - http://localhost:8080/employee
	 * 
	 * @RequestMapping(value = "/employee", // method = RequestMethod.POST, //
	 * produces = { MediaType.APPLICATION_JSON_VALUE }) public Employee
	 * addEmployee(@RequestBody Employee emp) {
	 * 
	 * System.out.println("(Service Side) Creating employee: " + emp.getEmpNo());
	 * 
	 * return employeeDAO.addEmployee(emp); }
	 * 
	 * // URL - http://localhost:8080/employee
	 * 
	 * @RequestMapping(value = "/employee", // method = RequestMethod.PUT, //
	 * produces = { MediaType.APPLICATION_JSON_VALUE }) public Employee
	 * updateEmployee(@RequestBody Employee emp) {
	 * 
	 * System.out.println("(Service Side) Editing employee: " + emp.getEmpNo());
	 * 
	 * return employeeDAO.updateEmployee(emp); }
	 * 
	 * // URL - http://localhost:8080/employee/{empNo}
	 * 
	 * @RequestMapping(value = "/employee/{empNo}", // method =
	 * RequestMethod.DELETE, // produces = { MediaType.APPLICATION_JSON_VALUE })
	 * public void deleteEmployee(@PathVariable("empNo") String empNo) {
	 * 
	 * System.out.println("(Service Side) Deleting employee: " + empNo);
	 * 
	 * employeeDAO.deleteEmployee(empNo); }
	 */
	 

}