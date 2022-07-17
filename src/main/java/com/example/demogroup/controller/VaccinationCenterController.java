package com.example.demogroup.controller;

import com.example.demogroup.model.dto.VaccinationCenterDto;
import com.example.demogroup.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/vaccinationCenter")
public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @GetMapping("/getAll")
    public ResponseEntity<List<VaccinationCenterDto>> getAllVaccinationCenters() {
        return vaccinationCenterService.getAllVaccinationCenters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VaccinationCenterDto> getVaccinationCenter(@PathVariable(name = "id") Integer id) {
        VaccinationCenterDto vaccinationCenter = vaccinationCenterService.getVaccinationCenter(id);

        return new ResponseEntity<>(vaccinationCenter, HttpStatus.OK);
    }

    @GetMapping("/getAvailable/{dateFrom}")
    public ResponseEntity<List<VaccinationCenterDto>> getAllAvailableCentersByDate(
            @PathVariable(name = "dateFrom") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateFrom, LocalDate dateTo) {

        List<VaccinationCenterDto> vaccinationCenterDtos = vaccinationCenterService.getAllVaccinationCentersByDate(dateFrom, dateTo);

        return new ResponseEntity<>(vaccinationCenterDtos, HttpStatus.OK);
    }



}
