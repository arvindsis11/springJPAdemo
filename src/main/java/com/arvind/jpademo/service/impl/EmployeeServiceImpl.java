package com.arvind.jpademo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.arvind.jpademo.model.Employee;
import com.arvind.jpademo.repositories.EmployeeRepo;
import com.arvind.jpademo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public List<Employee> findAllEmployees() {

		return employeeRepo.findAll();
	}

	@Override
	public ResponseEntity<Employee> findEmployeeById(Long id) {
		Optional<Employee> employee = employeeRepo.findById(id);
		if (employee.isPresent()) {
			return ResponseEntity.ok().body(employee.get());
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	public Employee saveEmployee(Employee employee) {

		return employeeRepo.save(employee);
	}

	@Override
	public ResponseEntity<Employee> deleteEmployee(Long id) {
		Optional<Employee> employee = employeeRepo.findById(id);
		if (employee.isPresent()) {
			employeeRepo.deleteById(id);
			return ResponseEntity.ok().body(employee.get());
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	public Employee updateEmployee(Long id, Employee newEmployee) {
		Optional<Employee> employee = employeeRepo.findById(id);
		return employee.map(data -> {
			data.setEmp_name(newEmployee.getEmp_name());
			return employeeRepo.save(data);
		}).orElseGet(() -> {
			newEmployee.setEmp_id(id);
			return employeeRepo.save(newEmployee);
		});

	}

}
