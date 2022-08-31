package com.example.demogroup.controller;


import com.example.demogroup.payload.response.ReservationResponse;
import com.example.demogroup.security.UserPrincipal;
import com.example.demogroup.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<ReservationResponse>> getAllReservations() {

        return reservationService.getAllReservations();
    }

    @PostMapping("/{timeSlotId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

    public ResponseEntity<ReservationResponse> addReservation(
                        @AuthenticationPrincipal UserPrincipal userPrincipal,
                        @PathVariable(name = "timeSlotId") Integer timeslotId) {

        return reservationService.addReservation(userPrincipal, timeslotId);

    }
}
