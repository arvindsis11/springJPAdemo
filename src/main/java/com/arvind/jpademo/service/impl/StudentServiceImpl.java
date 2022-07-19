package com.arvind.jpademo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.arvind.jpademo.model.Student;
import com.arvind.jpademo.repositories.StudentRepo;
import com.arvind.jpademo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public List<Student> findAllStudents() {

		return studentRepo.findAll();
	}

	@Override
	public ResponseEntity<Student> findStudentById(Long id) {
		Optional<Student> student = studentRepo.findById(id);
		if (student.isPresent()) {
			return ResponseEntity.ok().body(student.get());
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	public Student saveStudent(Student student) {

		return studentRepo.save(student);
	}

	@Override
	public ResponseEntity<Student> deleteStudent(Long id) {
		Optional<Student> student = studentRepo.findById(id);
		if (student.isPresent()) {
			studentRepo.deleteById(id);
			return ResponseEntity.ok().body(student.get());
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	public Student updateStudent(Long id, Student newStudent) {
		Optional<Student> student = studentRepo.findById(id);
		return student.map(data -> {
			data.setS_name(newStudent.getS_name());
			return studentRepo.save(data);
		}).orElseGet(() -> {
			newStudent.setS_id(id);
			return studentRepo.save(newStudent);
		});

	}

}
