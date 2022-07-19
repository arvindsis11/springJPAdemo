package com.arvind.jpademo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arvind.jpademo.model.Faculty;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty, Long> {

}
