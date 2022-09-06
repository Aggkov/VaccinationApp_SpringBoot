package com.example.demogroup.service;

import com.example.demogroup.payload.VaccinationResponse;
import com.example.demogroup.security.UserPrincipal;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VaccinationService {

     ResponseEntity<List<VaccinationResponse>> getAllVaccinations();
     ResponseEntity<byte[]> createVaccination(UserPrincipal userPrincipal, Integer reservationId);



}
