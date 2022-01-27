package com.hospital.hospitalSystem.repository;

import com.hospital.hospitalSystem.domain.PatientDiagnosisData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository for do patient diagnosis data database operations
 * */
@Repository
public interface PatientDiagnosisDataRepository extends JpaRepository<PatientDiagnosisData,Integer> {
}
