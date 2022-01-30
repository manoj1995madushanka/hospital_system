package com.hospital.hospitalSystem.service;

import com.hospital.hospitalSystem.domain.Physician;

import java.util.List;

public interface PhysicianService {
    void createPhysician(Physician physician);

    List<Physician> searchPhysicians(Physician searchObject);
}
