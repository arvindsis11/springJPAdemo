package com.arvind.jpademo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.arvind.jpademo.model.College;
import com.arvind.jpademo.repositories.CollegeRepo;
import com.arvind.jpademo.service.CollegeService;

@Service
@Component
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	private CollegeRepo collegeRepo;

	@Override
	public List<College> findAllColleges() {

		return collegeRepo.findAll();
	}

	@Override
	public ResponseEntity<College> findCollegeById(Long id) {
		Optional<College> college = collegeRepo.findById(id);
		if (college.isPresent()) {
			return ResponseEntity.ok().body(college.get());
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	public College saveCollege(College college) {

		return collegeRepo.save(college);
	}

	@Override
	public ResponseEntity<College> deleteCollege(Long id) {
		Optional<College> college = collegeRepo.findById(id);
		if (college.isPresent()) {
			collegeRepo.deleteById(id);
			return ResponseEntity.ok().body(college.get());
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	public College updateCollege(Long id, College newCollege) {
		Optional<College> college = collegeRepo.findById(id);
		return college.map(data -> {
			data.setC_name(newCollege.getC_name());
			return collegeRepo.save(data);
		}).orElseGet(() -> {
			newCollege.setC_id(id);
			return collegeRepo.save(newCollege);
		});

	}

}
