package com.arvind.jpademo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.arvind.jpademo.model.College;

public interface CollegeService {
	public List<College> findAllColleges();

	public ResponseEntity<College> findCollegeById(Long id);

	public College saveCollege(College college);

	public ResponseEntity<College> deleteCollege(Long id);

	public College updateCollege(Long id, College newCollege);
}
