package com.hospital.hospitalSystem.service;

import com.hospital.hospitalSystem.repository.PhysicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * contains service operations of physician related functionalities
 *
 * @author Manoj
 */
@Service
public class PhysicianService {
    @Autowired
    private PhysicianRepository physicianRepository;
}
