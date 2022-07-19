package com.arvind.jpademo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.arvind.jpademo.model.Faculty;
import com.arvind.jpademo.repositories.FacultyRepo;
import com.arvind.jpademo.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	private FacultyRepo facultyRepo;

	@Override
	public List<Faculty> findAllFaculties() {

		return facultyRepo.findAll();
	}

	@Override
	public ResponseEntity<Faculty> findFacultyById(Long id) {
		Optional<Faculty> faculty = facultyRepo.findById(id);
		if (faculty.isPresent()) {
			return ResponseEntity.ok().body(faculty.get());
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	public Faculty saveFaculty(Faculty faculty) {

		return facultyRepo.save(faculty);
	}

	@Override
	public ResponseEntity<Faculty> deleteFaculty(Long id) {
		Optional<Faculty> faculty = facultyRepo.findById(id);
		if (faculty.isPresent()) {
			facultyRepo.deleteById(id);
			return ResponseEntity.ok().body(faculty.get());
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	public Faculty updateFaculty(Long id, Faculty newFaculty) {
		Optional<Faculty> faculty = facultyRepo.findById(id);
		return faculty.map(data -> {
			data.setF_name(newFaculty.getF_name());
			return facultyRepo.save(data);
		}).orElseGet(() -> {
			newFaculty.setF_id(id);
			return facultyRepo.save(newFaculty);
		});

	}

}
