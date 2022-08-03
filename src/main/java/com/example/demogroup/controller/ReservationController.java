package com.example.demogroup.controller;


import com.example.demogroup.model.Reservation;
import com.example.demogroup.payload.ReservationResponse;
import com.example.demogroup.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/{userId}/{date}")
    public ResponseEntity<Reservation> addReservation(
                                                      @PathVariable (name = "userId") Integer userId,
                                                      @PathVariable(name = "date") Integer timeslotId) {
        Reservation newReservation = reservationService.addReservation(userId, timeslotId);

        return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
    }
}
