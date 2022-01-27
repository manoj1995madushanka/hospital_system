package com.hospital.hospitalSystem.repository;

import com.hospital.hospitalSystem.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository for do patient database operations
 * */
@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
