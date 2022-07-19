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

import com.arvind.jpademo.model.College;
import com.arvind.jpademo.service.CollegeService;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

	@Autowired
	private CollegeService collegeService;

	// for listing all the students
	@GetMapping
	public List<College> getAllStudents() {
		return collegeService.findAllColleges();
	}

	@PostMapping
	public College createStudent(@RequestBody College college) {

		return collegeService.saveCollege(college);
	}

	// get college details by id;
	@GetMapping("/{id}")
	public ResponseEntity<College> getCollegeById(@PathVariable(value = "id") long id) {
		return collegeService.findCollegeById(id);

	}

	@PutMapping("/{id}")
	public College updateCollege(@PathVariable(value = "id") long id, @RequestBody College newCollege) {
		return collegeService.updateCollege(id, newCollege);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<College> deleteCollege(@PathVariable(value = "id") Long id) {
		return collegeService.deleteCollege(id);
	}
}
