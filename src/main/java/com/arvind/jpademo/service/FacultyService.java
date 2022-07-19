package com.arvind.jpademo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.arvind.jpademo.model.Faculty;

public interface FacultyService {
	public List<Faculty> findAllFaculties();

	public ResponseEntity<Faculty> findFacultyById(Long id);

	public Faculty saveFaculty(Faculty faculty);

	public ResponseEntity<Faculty> deleteFaculty(Long id);

	public Faculty updateFaculty(Long id, Faculty newFaculty);
}
