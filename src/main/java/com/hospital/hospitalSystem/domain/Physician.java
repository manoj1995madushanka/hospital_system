package com.hospital.hospitalSystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
    //@GeneratedValue(generator="increment")
    //@GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private String id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "department")
    private String department; // need search
    @Column(name = "educationQualification")
    private String educationQualification;
    @Column(name = "yearsOfExperience")
    private Integer yearsOfExperience;
    @Column(name = "state")
    private String state; // need search
    @Column(name = "insurancePlan")
    private String insurancePlan;// need search
}