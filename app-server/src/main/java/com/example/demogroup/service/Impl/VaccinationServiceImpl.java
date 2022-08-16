package com.example.demogroup.service.Impl;

import com.example.demogroup.model.Vaccination;
import com.example.demogroup.payload.VaccinationDto;
import com.example.demogroup.repository.VaccinationRepository;
import com.example.demogroup.service.VaccinationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VaccinationServiceImpl implements VaccinationService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private VaccinationRepository vaccinationRepository;

    @Override
    public ResponseEntity<List<VaccinationDto>> getAllVaccinations() {
        List<Vaccination> vaccinations = new ArrayList<>(vaccinationRepository.findAll());
        List<VaccinationDto> vaccinationResponse = vaccinations.stream()
                .map(vaccination -> modelMapper.map(vaccination , VaccinationDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(vaccinationResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VaccinationDto> addVaccination(VaccinationDto vaccination,Integer userId) {

        return null;
    }

}
