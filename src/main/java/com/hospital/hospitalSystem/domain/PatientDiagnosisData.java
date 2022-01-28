package com.hospital.hospitalSystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

/**
 * DAO for Patient history of hospital
 *
 * @author Manoj
 */
@Entity
@Table(name="diagnosisdata")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientDiagnosisData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer diagnosisId;
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
