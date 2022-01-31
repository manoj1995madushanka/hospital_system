package com.hospital.hospitalSystem.service;

import com.hospital.hospitalSystem.domain.Patient;
import com.hospital.hospitalSystem.domain.PatientDiagnosisData;
import com.hospital.hospitalSystem.domain.Physician;
import com.hospital.hospitalSystem.dto.DiagnosisData;
import com.hospital.hospitalSystem.dto.PatientHistory;
import com.hospital.hospitalSystem.repository.PatientDiagnosisDataRepository;
import com.hospital.hospitalSystem.repository.PatientRepository;
import com.hospital.hospitalSystem.repository.PhysicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * contains service operations of patient diagnosis data related functionalities
 *
 * @author Manoj
 */
@Service
public class PatientDiagnosisDataServiceImpl implements PatientDiagnosisDataService {

    @Autowired
    private PatientDiagnosisDataRepository patientDiagnosisDataRepository;
    @Autowired
    private PhysicianRepository physicianRepository;
    @Autowired
    private PatientRepository patientRepository;

    /**
     * save diagnosis data to the db
     */
    @Override
    public void createDiagnosisData(DiagnosisData diagnosisData) {

        PatientDiagnosisData patientDiagnosisData = null;
        try {
            patientDiagnosisData = mapDiagnosisDataDao(diagnosisData);
        } catch (Exception e) {

        }
        patientDiagnosisDataRepository.save(patientDiagnosisData);
    }

    /**
     * map diagnosis data dto to dao before saving
     */
    private PatientDiagnosisData mapDiagnosisDataDao(DiagnosisData diagnosisData) throws SQLException {

        PatientDiagnosisData diagnosisDataDao = new PatientDiagnosisData();
        diagnosisDataDao.setDateOfDiagnosis(diagnosisData.getDateOfDiagnosis() == null ? new Date(System.currentTimeMillis())
                : diagnosisData.getDateOfDiagnosis());

        diagnosisDataDao.setDiagnosisProvided(diagnosisData.getDiagnosisProvided());
        diagnosisDataDao.setBillAmount(diagnosisData.getBillAmount());
        diagnosisDataDao.setModeOfPayment(diagnosisData.getModeOfPayment());
        diagnosisDataDao.setCardNumber(diagnosisData.getCardNumber());
        diagnosisDataDao.setFollowUpRequired(diagnosisData.getFollowUpRequired());
        diagnosisDataDao.setDateOfFollowUp(diagnosisData.getDateOfFollowUp());
        diagnosisDataDao.setSymptoms(diagnosisData.getSymptoms());

        Optional<Patient> existingPatient = patientRepository.findById(diagnosisData.getPatientId());

        if (existingPatient.isPresent()) {
            diagnosisDataDao.setPatient(existingPatient.get());
        } else {
            throw new SQLException("Patient not found");
        }

        Optional<Physician> existingPhysician = physicianRepository.findById(diagnosisData.getAdministeredBy());

        if (existingPhysician.isPresent()) {
            diagnosisDataDao.setPhysician(existingPhysician.get());
        } else {
            throw new SQLException("Physician not found");
        }

        return diagnosisDataDao;
    }

    /**
     * search patient histories for relevant patient id and map search result to dto object
     */
    @Override
    public List<PatientHistory> searchPatientHistories(Patient patient) {

        List<PatientDiagnosisData> patientHistoryList = patientDiagnosisDataRepository.searchPatientHistories(patient.getId());

        if (patientHistoryList != null) {
            List<PatientHistory> historyList = new ArrayList<>();

            for (PatientDiagnosisData diagnosisData : patientHistoryList) {

                PatientHistory patientHistory = new PatientHistory();
                if (diagnosisData.getPatient() != null) {

                    StringBuilder name = new StringBuilder();
                    if (diagnosisData.getPatient().getFirstName() != null)
                        name.append(diagnosisData.getPatient().getFirstName());
                    if (diagnosisData.getPatient().getLastName() != null)
                        name.append(" ").append(diagnosisData.getPatient().getLastName());

                    patientHistory.setName(name.toString());
                }

                patientHistory.setDateOfDiagnosis(diagnosisData.getDateOfDiagnosis());
                patientHistory.setDiagnosisProvided(diagnosisData.getDiagnosisProvided());
                patientHistory.setBillAmount(diagnosisData.getBillAmount());
                patientHistory.setSymptoms(diagnosisData.getSymptoms());
                patientHistory.setDateOfFollowUp(diagnosisData.getDateOfFollowUp());
                patientHistory.setModeOfPayment(diagnosisData.getModeOfPayment());

                patientHistory.setAdministeredBy(diagnosisData.getPhysician() != null ? diagnosisData.getPhysician().getId() : null);

                historyList.add(patientHistory);
            }
            return historyList;
        } else {
            return Collections.emptyList();
        }
    }
}
