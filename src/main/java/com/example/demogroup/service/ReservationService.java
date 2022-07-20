package com.example.demogroup.service;

import com.example.demogroup.model.Reservation;
import com.example.demogroup.model.dto.ReservationRequest;
import com.example.demogroup.model.dto.ReservationResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReservationService {

    ResponseEntity<List<ReservationResponse>> getAllReservations();

    Reservation addReservation(Integer userId, Integer timeslotId);

    Reservation getReservation(Integer id);

    Reservation updateReservation(Integer id, ReservationRequest reservationRequest);

    Reservation deleteReservation(Integer id);






}
