package com.example.hospitalmanagement.controller;

import com.example.hospitalmanagement.entity.Doctor;
import com.example.hospitalmanagement.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // Add Doctor
    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    // Get All Doctors
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // Get Doctor By ID
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    // Delete Doctor
    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return "Doctor deleted successfully";
    }

    // Update Doctor
    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        return doctorService.updateDoctor(id, doctor);
    }
}