package com.arvind.jpademo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arvind.jpademo.model.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
