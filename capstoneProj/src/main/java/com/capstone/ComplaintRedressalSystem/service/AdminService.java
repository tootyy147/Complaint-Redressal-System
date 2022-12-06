package com.capstone.ComplaintRedressalSystem.service;

import java.util.List;
import java.util.Optional;

import com.capstone.ComplaintRedressalSystem.model.Admin;

public interface AdminService {
	
	List<Admin> findAll();
	
	Admin findById(Long id);
	
	void deleteAdminById(Long id);
	
	Admin saveAdmin(Admin admin);

}
