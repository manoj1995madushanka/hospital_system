package com.hospital.hospitalSystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * DAO for Physician of hospital
 *
 * @author Manoj
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Physician {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String department; // need search
    private String educationQualification;
    private Integer yearsOfExperience;
    private String state; // need search
    private String insurancePlan;// need search
}