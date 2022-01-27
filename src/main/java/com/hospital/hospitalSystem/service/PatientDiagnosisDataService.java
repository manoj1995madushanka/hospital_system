package com.hospital.hospitalSystem.service;

import com.hospital.hospitalSystem.repository.PatientDiagnosisDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * contains service operations of patient diagnosis data related functionalities
 *
 * @author Manoj
 */
@Service
public class PatientDiagnosisDataService {
    @Autowired
    private PatientDiagnosisDataRepository patientDiagnosisDataRepository;
}
