package com.arvind.jpademo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arvind.jpademo.model.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{

}
