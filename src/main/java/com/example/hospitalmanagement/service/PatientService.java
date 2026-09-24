package com.example.hospitalmanagement.service;

import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // Save patient
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Get all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Get patient by ID
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    // Delete patient
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    // Update patient
    public Patient updatePatient(Long id, Patient patient) {
        Patient existingPatient = patientRepository.findById(id).orElse(null);

        if (existingPatient != null) {
            existingPatient.setName(patient.getName());
            existingPatient.setAge(patient.getAge());
            existingPatient.setGender(patient.getGender());
            existingPatient.setPhone(patient.getPhone());
            existingPatient.setDisease(patient.getDisease());

            return patientRepository.save(existingPatient);
        }

        return null;
    }
}