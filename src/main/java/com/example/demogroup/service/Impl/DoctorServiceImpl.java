package com.example.demogroup.service.Impl;

import com.example.demogroup.model.Doctor;
import com.example.demogroup.model.dto.DoctorDto;
import com.example.demogroup.repository.DoctorRepository;
import com.example.demogroup.service.DoctorService;
import com.example.demogroup.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>(doctorRepository.findAll());
        List<DoctorDto> doctorDto = doctors.stream()
                .map(doctor -> ObjectMapperUtils.map(doctor, DoctorDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(doctorDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DoctorDto> getDoctorByAFM(Integer afm) {
         Doctor doctor = doctorRepository.getDoctorById(afm);
         DoctorDto doctorDto = new DoctorDto(doctor.getId(),doctor.getFirstName(),doctor.getLastName());
         return new ResponseEntity<>(doctorDto, HttpStatus.OK);
    }

    @Override
    public Doctor getDoctorById(Integer id) {
        return doctorRepository.getDoctorById(id);
    }

    @Override
    public void deleteDoctorById(Integer id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public boolean doesDoctorExists(Integer afm) {
        return doctorRepository.existsDoctorById(afm);
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        if(doctorRepository.existsDoctorById(doctor.getId())) {
            doctorRepository.save(doctor);
        }
    }

    @Override
    public void saveDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

}
