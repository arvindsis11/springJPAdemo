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

import com.arvind.jpademo.model.Faculty;
import com.arvind.jpademo.service.FacultyService;

@RestController
@RequestMapping("/faculties")
public class FacultyController {

	@Autowired
	private FacultyService facultyService;

	// for listing all the students
	@GetMapping("/students")
	public List<Faculty> getAllFaculties() {
		return facultyService.findAllFaculties();
	}

	@PostMapping
	public Faculty createStudent(@RequestBody Faculty faculty) {

		return facultyService.saveFaculty(faculty);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Faculty> getFacultyById(@PathVariable(value = "id") Long id) {
		return facultyService.findFacultyById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Faculty> deleteStudent(@PathVariable(value = "id") Long id) {
		return facultyService.deleteFaculty(id);
	}

}