package com.example.demogroup.service;

import com.example.demogroup.model.VaccinationCenter;
import com.example.demogroup.model.dto.VaccinationCentersDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VaccinationCenterService {

    ResponseEntity <List<VaccinationCentersDto>> getAllVaccinationCenters();

    ResponseEntity<VaccinationCenter> addVaccinationCenter();

    ResponseEntity<VaccinationCenter> getVaccinationCenter(Integer id);

//    ResponseEntity<VaccinationCenter> updateVaccinationCenter(Integer id);






}
