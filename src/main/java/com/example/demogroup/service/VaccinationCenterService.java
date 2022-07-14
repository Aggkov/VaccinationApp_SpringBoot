package com.example.demogroup.service;

import com.example.demogroup.model.VaccinationCenter;
import com.example.demogroup.model.dto.VaccinationCenterDto;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface VaccinationCenterService {

    ResponseEntity <List<VaccinationCenterDto>> getAllVaccinationCenters();

    ResponseEntity<VaccinationCenter> addVaccinationCenter();

    ResponseEntity<VaccinationCenter> getVaccinationCenter(Integer id);

    ResponseEntity<List<VaccinationCenterDto>> getAllVaccinationCentersByDate(LocalDate dateFrom, LocalDate dateTo);

//    ResponseEntity<VaccinationCenter> updateVaccinationCenter(Integer id);






}
