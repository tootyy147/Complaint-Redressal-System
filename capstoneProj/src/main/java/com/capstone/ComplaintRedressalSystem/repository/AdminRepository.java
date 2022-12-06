package com.capstone.ComplaintRedressalSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import com.capstone.ComplaintRedressalSystem.model.Admin;

//@CrossOrigin(origins = "http://localhost:4200")
public interface AdminRepository extends JpaRepository<Admin, Long>{
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("SELECT a FROM Admin a where a.softDelete like %?1%")
	List<Admin> findAllBySoftDelete(String id);

}
