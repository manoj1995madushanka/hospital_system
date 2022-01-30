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
@Table(name = "diagnosisdata")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientDiagnosisData {
    @Id
    @Column(name = "diagnosisId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer diagnosisId;
    @Column(name = "patientId")
    private Integer patientId;
    @Column(name = "symptoms")
    private String symptoms; // represent the symptoms of the patient
    @Column(name = "diagnosisProvided")
    private String diagnosisProvided; // represents the diagnosis provided for the patient
    @Column(name = "administeredBy")
    private String administeredBy; // represents the doctor who had visited the patient
    @Column(name = "dateOfDiagnosis")
    private Date dateOfDiagnosis; // date of diagnosis of the patient
    @Column(name = "followUpRequired")
    private Boolean followUpRequired; // whether the follow-up required or not
    @Column(name = "dateOfFollowUp")
    private Date dateOfFollowUp; // date of follow-up for the patient
    @Column(name = "billAmount")
    private Double billAmount;
    @Column(name = "cardNumber")
    private Integer cardNumber;
    @Column(name = "modeOfPayment")
    private String modeOfPayment;
}
