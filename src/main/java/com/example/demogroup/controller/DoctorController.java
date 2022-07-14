package com.example.demogroup.controller;

import com.example.demogroup.model.Doctor;
import com.example.demogroup.model.dto.DoctorDto;
import com.example.demogroup.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/doctors/{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable Integer id) {
        return doctorService.getDoctorByAFM(id);
    }

    @DeleteMapping("/doctors/{id}")
    public String deleteDoctor(@PathVariable Integer id) {
        Doctor doctor = doctorService.getDoctorById(id);
//        if (doctor == null) {
//            throw new DoctorNotFoundException("Doctor id not found - " + id);
//        }
        doctorService.deleteDoctorById(id);
        return ("Doctor deleted ID: " + id);
    }

    // ΜΗΠΩΣ ΘΕΛΟΥΝ ΩΣ ΟΡΙΣΜΑ DOCTOR DTO ???
    @PostMapping("/doctors")
    public void addDoctor(@RequestBody Doctor insertedDoctor) {
        if (!doctorService.doesDoctorExists(insertedDoctor.getId())) {
            doctorService.saveDoctor(insertedDoctor);
        }
    }

    @PutMapping("/doctors")
    public Doctor updateDoctor(@RequestBody DoctorDto doctorDto) {
        Doctor doctor = new Doctor(doctorDto.getId(),doctorDto.getFirstName(),doctorDto.getLastName());

        Doctor updatedDoctor = doctorService.getDoctorById(doctor.getId());

        updatedDoctor.setFirstName(doctorDto.getFirstName());
        updatedDoctor.setLastName(doctorDto.getLastName());
        doctorService.saveDoctor(updatedDoctor);
        return updatedDoctor;
    }
}
