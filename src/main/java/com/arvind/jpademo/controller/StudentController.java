package com.arvind.jpademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arvind.jpademo.model.Student;
import com.arvind.jpademo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	//for listing all the students
	@GetMapping
	public List<Student> getAllStudents(){
		return studentService.findAllStudents();
	}
	
	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		
		return studentService.saveStudent(student);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value="id")Long id){
		return studentService.findStudentById(id);
	}
	@PutMapping("/{id}")
	public Student updateUser(@PathVariable(value="id") long id,@RequestBody Student newStudent) {
		return studentService.updateStudent(id, newStudent);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable(value = "id") Long id) {
		return studentService.deleteStudent(id);
	}
	
	
}