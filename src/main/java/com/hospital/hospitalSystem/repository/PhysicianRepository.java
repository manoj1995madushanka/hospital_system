package com.hospital.hospitalSystem.repository;

import com.hospital.hospitalSystem.domain.Physician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository for do physician database operations
 * */
@Repository
public interface PhysicianRepository extends JpaRepository<Physician,String> {
}
