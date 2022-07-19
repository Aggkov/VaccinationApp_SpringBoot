package com.example.demogroup.controller;


import com.example.demogroup.model.Reservation;
import com.example.demogroup.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Reservation>> getAllReservations() {
//        List<ReservationResponse> reservations = reservationService.getAllReservations();

        return reservationService.getAllReservations();
    }

    @PostMapping("/{userId}/{date}")
    public ResponseEntity<Reservation> addReservation(
                                                      @PathVariable (name = "userId") Integer userId,
                                                      @PathVariable(name = "date") Integer timeslotId) {
        Reservation newReservation = reservationService.addReservation(userId, timeslotId);

        return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
    }

//    @RequestBody ReservationRequest reservationRequest,

//    reservationRequest

}
