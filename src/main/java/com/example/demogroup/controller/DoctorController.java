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


    @PostMapping("/doctors")
    public Doctor addDoctor(@RequestBody DoctorDto doctorDto) {
        Doctor newDoctor = null;
        if (!doctorService.doesDoctorExists(doctorDto.getId())) {
            newDoctor = new Doctor(doctorDto.getId(),doctorDto.getFirstName(),doctorDto.getLastName());
        }
        doctorService.saveDoctor(newDoctor);
        return newDoctor;
    }

    /**
     * First finds the doctor in DB, based on the id of the doctor that returned through the DTO,
     * then modifies his values in doctor's fields in DB and saves the changes.
     * @param doctorDto
     * @return
     */
    @PutMapping("/doctors/{id}")
    public Doctor updateDoctor(@RequestBody DoctorDto doctorDto) {
        // find doctor
        Doctor doctor = doctorService.getDoctorById(doctorDto.getId());
        // assign new values
        doctor.setFirstName(doctorDto.getFirstName());
        doctor.setLastName(doctorDto.getLastName());
        doctorService.updateDoctor(doctor);
        return doctor;
    }
}
