package com.hospital.hospitalSystem.service;

import com.hospital.hospitalSystem.domain.Admin;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface AdminService extends UserDetailsService {
    Admin createAdmin(Admin admin);

    List<Admin> getAllAdmins();

    Admin getAdminById(int id);

    void deleteAdminById(int id);
}
