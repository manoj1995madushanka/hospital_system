package com.hospital.hospitalSystem.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.hospital.hospitalSystem.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hospital.hospitalSystem.domain.Admin;
import com.hospital.hospitalSystem.repository.AdminRepository;

/**
 * contains service operations of admin related functionalities
 *
 * @author Manoj
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Admin createAdmin(Admin admin) {
        String encryptedPassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encryptedPassword);
        admin.setRoles(Arrays.asList(new Role("ROLE_USER")));

        return adminRepository.save(admin);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Admin user = adminRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminById(int id) {
        Optional<Admin> admin = adminRepository.findById(id);
        return admin.isPresent() ? admin.get() : null;
    }

    @Override
    public void deleteAdminById(int id) {
        adminRepository.deleteById(id);
    }

}
