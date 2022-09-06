package com.example.demogroup.controller;

import com.example.demogroup.payload.VaccinationResponse;
import com.example.demogroup.security.UserPrincipal;
import com.example.demogroup.service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vaccinations")
public class VaccinationController {

    @Autowired
    private VaccinationService vaccinationService;

    @GetMapping
    public ResponseEntity<List<VaccinationResponse>> allVaccinations() {
        return vaccinationService.getAllVaccinations();
    }

    @PostMapping("/{reservationId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('DOCTOR')")
    public ResponseEntity<byte[]> createVaccination(@AuthenticationPrincipal UserPrincipal userPrincipal,
                                                                 @PathVariable(name = "reservationId") Integer reservationId) {

        return vaccinationService.createVaccination(userPrincipal, reservationId);
    }
}
