package com.hospital.hospitalSystem.dto;

import lombok.Data;

import java.sql.Date;

/**
 * contains attributes for show patient history data
 * */
@Data
public class PatientHistory {
    private String name;
    private String symptoms;
    private String diagnosisProvided;
    private String administeredBy;
    private Date dateOfDiagnosis;
    private Date dateOfFollowUp;
    private Double billAmount;
    private String modeOfPayment;
}
