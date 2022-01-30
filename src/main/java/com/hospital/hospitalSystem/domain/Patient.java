package com.hospital.hospitalSystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

/**
 * DAO for Patient of hospital
 *
 * @author Manoj
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Patient {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "password")
    private String password;
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;
    @Column(name = "email")
    private String email;
    @Column(name = "contact")
    private Integer contact;
    @Column(name = "state")
    private String state;
    @Column(name = "insurancePlan")
    private String insurancePlan;
}
