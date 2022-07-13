package com.example.demogroup.controller;

import com.example.demogroup.model.VaccinationCenter;
import com.example.demogroup.model.dto.VaccinationCenterDto;
import com.example.demogroup.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
    public ResponseEntity<VaccinationCenter> getVaccinationCenter(@PathVariable(name = "id") Integer id) {
        return vaccinationCenterService.getVaccinationCenter(id);
    }

    @GetMapping("/getAvailable/{dateFrom}")
    public ResponseEntity<List<VaccinationCenterDto>> getAllAvailableCentersByDate(
            @PathVariable(name = "dateFrom") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateFrom, LocalDate dateTo) {

        return vaccinationCenterService.getAllVaccinationCentersByDate(dateFrom, dateTo);
    }



}
