package com.capstone.ComplaintRedressalSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capstone.ComplaintRedressalSystem.model.Admin;
import com.capstone.ComplaintRedressalSystem.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Override
	public List<Admin> findAll()
	{
		return adminRepo.findAll();
	}

	@Override
	public Admin findById(Long id) {
		if(adminRepo.findById(id).isPresent()) {
			return adminRepo.findById(id).get();
		}
		return null;
		
	}

	@Override
	public void deleteAdminById(Long id) {
		Admin admin = findById(id);
		//adminRepo.deleteById(id);
		adminRepo.delete(admin);
	}

	@Override
	public Admin saveAdmin(Admin admin) {
		adminRepo.save(admin);
		return admin;
	}
	
	

}
