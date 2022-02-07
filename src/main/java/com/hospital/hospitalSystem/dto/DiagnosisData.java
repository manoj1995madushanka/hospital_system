package com.hospital.hospitalSystem.dto;

import lombok.Data;

import java.sql.Date;

/**
 * represent patient diagnosis data endpoint return dto
 * */
@Data
public class DiagnosisData {
    private Integer patientId;
    private String symptoms; // represent the symptoms of the patient
    private String diagnosisProvided; // represents the diagnosis provided for the patient
    private String administeredBy; // represents the doctor who had visited the patient
    private Date dateOfDiagnosis; // date of diagnosis of the patient
    private Boolean followUpRequired; // whether the follow-up required or not
    private Date dateOfFollowUp; // date of follow-up for the patient
    private Double billAmount;
    private Integer cardNumber;
    private String modeOfPayment;
}
