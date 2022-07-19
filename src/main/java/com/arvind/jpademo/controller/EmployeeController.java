package com.arvind.jpademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arvind.jpademo.model.Employee;
import com.arvind.jpademo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// for listing all the students
	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.findAllEmployees();
	}

	@PostMapping
	public Employee createStudent(@RequestBody Employee employee) {

		return employeeService.saveEmployee(employee);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long id) {
		return employeeService.findEmployeeById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteStudent(@PathVariable(value = "id") Long id) {
		return employeeService.deleteEmployee(id);
	}

}