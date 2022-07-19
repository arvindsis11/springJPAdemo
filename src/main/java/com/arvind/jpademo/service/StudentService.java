package com.arvind.jpademo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.arvind.jpademo.model.Student;

public interface StudentService {
	public List<Student> findAllStudents();

	public ResponseEntity<Student> findStudentById(Long id);

	public Student saveStudent(Student student);

	public ResponseEntity<Student> deleteStudent(Long id);

	public Student updateStudent(Long id, Student newStudent);
}
