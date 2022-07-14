package com.example.demogroup.service;

import com.example.demogroup.model.Doctor;
import com.example.demogroup.model.dto.DoctorDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DoctorService {

    public ResponseEntity<List<DoctorDto>> getAllDoctors();

    public ResponseEntity<DoctorDto> getDoctorByAFM(Integer afm);

    public Doctor getDoctorById(Integer id);

    public void deleteDoctorById(Integer id);

    public boolean doesDoctorExists(Integer afm);

    public void saveDoctor(Doctor doctor);

}
