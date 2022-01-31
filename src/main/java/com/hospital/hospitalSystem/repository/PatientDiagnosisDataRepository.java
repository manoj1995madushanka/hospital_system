package com.hospital.hospitalSystem.repository;

import com.hospital.hospitalSystem.domain.PatientDiagnosisData;
import com.hospital.hospitalSystem.dto.PatientHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * repository for do patient diagnosis data database operations
 * */
@Repository
public interface PatientDiagnosisDataRepository extends JpaRepository<PatientDiagnosisData,Integer> {

    @Query(value = "SELECT * FROM diagnosisdata WHERE patient_id=?1",nativeQuery = true)
    List<PatientDiagnosisData> searchPatientHistories(Integer id);
}
