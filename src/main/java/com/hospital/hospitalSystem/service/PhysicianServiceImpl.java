package com.hospital.hospitalSystem.service;

import com.hospital.hospitalSystem.domain.Physician;
import com.hospital.hospitalSystem.repository.PhysicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * contains service operations of physician related functionalities
 *
 * @author Manoj
 */
@Service
public class PhysicianServiceImpl implements PhysicianService {
    @Autowired
    private PhysicianRepository physicianRepository;

    @Override
    public void createPhysician(Physician physician) {
        physician.setId("TEST");// this id will automatically set by sql trigger
        physicianRepository.save(physician);
    }
}
