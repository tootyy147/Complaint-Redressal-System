package com.capstone.ComplaintRedressalSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.ComplaintRedressalSystem.model.Admin;
import com.capstone.ComplaintRedressalSystem.repository.AdminRepository;
import com.capstone.ComplaintRedressalSystem.service.AdminService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	private AdminRepository adminRepo;
	
	@GetMapping("/get-admin")
	public ResponseEntity<List<Admin>> getAdminDetails()
	{
		List<Admin> admin = adminService.findAll();
		return new ResponseEntity<List<Admin>>(admin, HttpStatus.OK);
	}
	
	
	@GetMapping("/get-adminlist")
	public ResponseEntity<List<Admin>> findAllBySoftDelete()
	{
		List<Admin> admin = adminRepo.findAllBySoftDelete("0");
		return new ResponseEntity<List<Admin>>(admin, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/get-admin/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable("id") Long id)
	{
		Admin adminDetails = adminService.findById(id);
		return new ResponseEntity<Admin>(adminDetails, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-admin/{id}")
	public ResponseEntity<String> deleteAdmin(@PathVariable("id") Long id)
	{
		//adminService.deleteAdminById(id);
		adminService.deleteAdminById(id);
		return new ResponseEntity<String>("Admin is deleted Successfully", HttpStatus.OK);
	}
	
	@PostMapping("/save-admin")
	public ResponseEntity<Admin> saveAdmin(@Validated @RequestBody Admin admin)
	{
		Admin adminSave = adminService.saveAdmin(admin);
		return new ResponseEntity<Admin>(adminSave, HttpStatus.OK);
	}
	

}
