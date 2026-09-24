package com.example.hospitalmanagement.service;

import com.example.hospitalmanagement.entity.Appointment;
import com.example.hospitalmanagement.entity.Doctor;
import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.repository.AppointmentRepository;
import com.example.hospitalmanagement.repository.DoctorRepository;
import com.example.hospitalmanagement.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public AppointmentService(
            AppointmentRepository appointmentRepository,
            PatientRepository patientRepository,
            DoctorRepository doctorRepository) {

        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    public Appointment saveAppointment(Appointment appointment) {

        Long patientId = appointment.getPatient().getId();
        Long doctorId = appointment.getDoctor().getId();

        Patient patient = patientRepository.findById(patientId).orElse(null);
        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    public Appointment updateAppointment(Long id, Appointment appointment) {

        Appointment existingAppointment =
                appointmentRepository.findById(id).orElse(null);

        if (existingAppointment != null) {

            Long patientId = appointment.getPatient().getId();
            Long doctorId = appointment.getDoctor().getId();

            Patient patient =
                    patientRepository.findById(patientId).orElse(null);

            Doctor doctor =
                    doctorRepository.findById(doctorId).orElse(null);

            existingAppointment.setPatient(patient);
            existingAppointment.setDoctor(doctor);
            existingAppointment.setAppointmentDate(
                    appointment.getAppointmentDate());
            existingAppointment.setReason(
                    appointment.getReason());

            return appointmentRepository.save(existingAppointment);
        }

        return null;
    }
}