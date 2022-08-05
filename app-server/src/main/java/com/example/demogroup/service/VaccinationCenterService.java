package com.example.demogroup.service;

import com.example.demogroup.model.VaccinationCenter;
import com.example.demogroup.payload.VaccinationCenterResponse;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface VaccinationCenterService {

    ResponseEntity <List<VaccinationCenterResponse>> getAllVaccinationCenters();

    ResponseEntity<VaccinationCenter> addVaccinationCenter();

    VaccinationCenterResponse getVaccinationCenter(Integer id);

    List<VaccinationCenterResponse> getAllVaccinationCentersByDate(LocalDate dateFrom, LocalDate dateTo);

//    ResponseEntity<VaccinationCenter> updateVaccinationCenter(Integer id);






}
