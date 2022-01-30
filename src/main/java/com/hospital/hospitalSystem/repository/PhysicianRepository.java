package com.hospital.hospitalSystem.repository;

import com.hospital.hospitalSystem.domain.Physician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * repository for do physician database operations
 * */
@Repository
public interface PhysicianRepository extends JpaRepository<Physician,String> {


    @Query(value = "SELECT * FROM PHYSICIAN WHERE (?1 IS NULL OR department = ?1) AND (?1 IS NULL OR state = ?1)" +
            " AND (?1 IS NULL OR insurance_plan = ?1)",nativeQuery = true)
    Optional<List<Physician>> searchPhysicians(String department, String state, String insurancePlan);
}
