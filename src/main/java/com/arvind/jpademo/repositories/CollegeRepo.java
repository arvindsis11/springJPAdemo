package com.arvind.jpademo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arvind.jpademo.model.College;
@Repository
public interface CollegeRepo extends JpaRepository<College, Long>{
//	 @Query("SELECT c FROM College c LEFT JOIN c.c_name a WHERE c.c_id = a.college")
//	  List<College> findAll();
}
