package com.example.demogroup.service.Impl;

import com.example.demogroup.exception.ResourceNotFoundException;
import com.example.demogroup.model.VaccinationCenter;
import com.example.demogroup.model.dto.VaccinationCenterDto;
import com.example.demogroup.repository.VaccinationCenterRepository;
import com.example.demogroup.service.VaccinationCenterService;
import com.example.demogroup.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    @Override
    public ResponseEntity<List<VaccinationCenterDto>> getAllVaccinationCenters() {

        List<VaccinationCenter> centers = new ArrayList<>(vaccinationCenterRepository.findAll());

        List<VaccinationCenterDto> centersDto = centers.stream()
                .map(center -> ObjectMapperUtils.map(center, VaccinationCenterDto.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(centersDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VaccinationCenter> addVaccinationCenter() {
        return null;
    }


    @Override
    public ResponseEntity<VaccinationCenter> getVaccinationCenter(Integer id) {
        VaccinationCenter center = vaccinationCenterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vaccination Center with id = " + id + " was not found"));

        return new ResponseEntity<>(center, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<VaccinationCenterDto>> getAllVaccinationCentersByDate(LocalDate dateFrom, LocalDate dateTo) {

        dateTo = dateFrom.plusMonths(1);

        List<VaccinationCenter> centers = vaccinationCenterRepository.findAllCentersByDate(dateFrom, dateTo);

        List<VaccinationCenterDto> centerDtos = centers.stream()
                .map(c -> ObjectMapperUtils.map(c, VaccinationCenterDto.class))
                .collect(Collectors.toList());


        return new ResponseEntity<>(centerDtos, HttpStatus.OK);
    }

//    @Override
//    public ResponseEntity<VaccinationCenter> updateVaccinationCenter(Integer id) {
//        return null;
//    }
}
