package com.hospital.hospitalSystem.service;

import com.hospital.hospitalSystem.domain.Patient;
import com.hospital.hospitalSystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * contains service operations of patient related functionalities
 *
 * @author Manoj
 */
@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public void createPatient(Patient patient) {
    }
}
