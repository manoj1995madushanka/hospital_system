package com.hospital.hospitalSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.hospitalSystem.domain.Admin;

/**
 * repository for do admin database operations
 * */
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

    Admin findByUsername(String username);
}
