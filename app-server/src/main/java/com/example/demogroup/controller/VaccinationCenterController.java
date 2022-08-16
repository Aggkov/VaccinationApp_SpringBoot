package com.example.demogroup.controller;

import com.example.demogroup.payload.VaccinationCenterResponse;
import com.example.demogroup.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/vaccinationCenters")
public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @GetMapping
    public ResponseEntity<List<VaccinationCenterResponse>> getAllVaccinationCenters(Authentication authentication) {
        System.out.println(authentication.getPrincipal());
        return vaccinationCenterService.getAllVaccinationCenters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VaccinationCenterResponse> getVaccinationCenter(@PathVariable(name = "id") Integer id) {
        VaccinationCenterResponse vaccinationCenter = vaccinationCenterService.getVaccinationCenter(id);

        return new ResponseEntity<>(vaccinationCenter, HttpStatus.OK);
    }

    @GetMapping("/getAvailable/{dateFrom}")
    public ResponseEntity<List<VaccinationCenterResponse>> getAllAvailableCentersByDate(
            @PathVariable(name = "dateFrom") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateFrom, LocalDate dateTo) {

        List<VaccinationCenterResponse> vaccinationCenterResponses = vaccinationCenterService.getAllVaccinationCentersByDate(dateFrom, dateTo);

        return new ResponseEntity<>(vaccinationCenterResponses, HttpStatus.OK);
    }



}
