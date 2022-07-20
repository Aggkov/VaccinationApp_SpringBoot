package com.example.demogroup.service;

import com.example.demogroup.model.dto.VaccinationDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VaccinationService {

     ResponseEntity<List<VaccinationDto>> getAllVaccinations();
     ResponseEntity<VaccinationDto> addVaccination(VaccinationDto vaccination,Integer userId);



}