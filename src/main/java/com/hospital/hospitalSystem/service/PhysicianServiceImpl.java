package com.hospital.hospitalSystem.service;

import com.hospital.hospitalSystem.domain.Physician;
import com.hospital.hospitalSystem.repository.PhysicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Physician> searchPhysicians(Physician searchObject) {

        fixSearchParams(searchObject);

        Optional<List<Physician>> optionalPhysicians = physicianRepository.searchPhysicians(searchObject.getDepartment(),
                searchObject.getState(), searchObject.getInsurancePlan());

        return optionalPhysicians.isPresent() ? optionalPhysicians.get() : Collections.emptyList();
    }

    private void fixSearchParams(Physician searchObject) {
        if (searchObject.getDepartment() != null && searchObject.getDepartment().isEmpty())
        {
            searchObject.setDepartment(null);
        }
        if (searchObject.getState() != null && searchObject.getState().isEmpty())
        {
            searchObject.setState(null);
        }
        if (searchObject.getInsurancePlan() != null && searchObject.getInsurancePlan().isEmpty())
        {
            searchObject.setInsurancePlan(null);
        }
    }
}
