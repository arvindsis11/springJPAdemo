package com.arvind.jpademo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.arvind.jpademo.model.Employee;

public interface EmployeeService {
	public List<Employee> findAllEmployees();

	public ResponseEntity<Employee> findEmployeeById(Long id);

	public Employee saveEmployee(Employee employee);

	public ResponseEntity<Employee> deleteEmployee(Long id);

	public Employee updateEmployee(Long id, Employee newEmployee);
}
