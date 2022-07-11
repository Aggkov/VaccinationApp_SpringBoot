package com.example.demogroup.controller;

import com.example.demogroup.model.dto.VaccinationCentersDto;
import com.example.demogroup.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @GetMapping("/vaccinationCenters")
    public ResponseEntity<List<VaccinationCentersDto>> getAllVaccinationCenters() {
        return vaccinationCenterService.getAllVaccinationCenters();
    }
}
