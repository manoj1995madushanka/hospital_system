package com.hospital.hospitalSystem.service;

import com.hospital.hospitalSystem.domain.Patient;
import com.hospital.hospitalSystem.domain.PatientDiagnosisData;
import com.hospital.hospitalSystem.domain.Physician;
import com.hospital.hospitalSystem.dto.DiagnosisData;
import com.hospital.hospitalSystem.dto.PatientHistory;

import java.util.List;

public interface PatientDiagnosisDataService {
    String createDiagnosisData(DiagnosisData diagnosisData);

    List<PatientHistory> searchPatientHistories(Patient patient);
}
