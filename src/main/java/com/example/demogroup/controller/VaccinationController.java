package com.example.demogroup.controller;

import com.example.demogroup.payload.VaccinationDto;
import com.example.demogroup.service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vaccination")
public class VaccinationController {

    @Autowired
    private VaccinationService vaccinationService;

    @GetMapping("/getAll")
    public ResponseEntity<List<VaccinationDto>> allVaccinations() {
        return vaccinationService.getAllVaccinations();
    }
}
