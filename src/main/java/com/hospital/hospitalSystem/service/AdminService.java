package com.hospital.hospitalSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.hospitalSystem.domain.Admin;
import com.hospital.hospitalSystem.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;

	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	public void createAdmin(Admin admin) {
		adminRepository.save(admin);
		
	}

	public Admin getAdminById(int id) {
		Optional<Admin> admin =  adminRepository.findById(id);
		return admin.isPresent()? admin.get():null;
	}

	public void deleteAdminById(int id) {
		adminRepository.deleteById(id);
	}

}
