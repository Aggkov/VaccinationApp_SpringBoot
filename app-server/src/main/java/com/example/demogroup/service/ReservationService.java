package com.example.demogroup.service;

import com.example.demogroup.model.Reservation;
import com.example.demogroup.payload.request.ReservationRequest;
import com.example.demogroup.payload.response.ReservationResponse;
import com.example.demogroup.security.UserPrincipal;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReservationService {

    ResponseEntity<List<ReservationResponse>> getAllReservations();

    ResponseEntity<ReservationResponse> addReservation(UserPrincipal userPrincipal, Integer timeslotId);

    Reservation getReservation(Integer id);

    Reservation updateReservation(Integer id, ReservationRequest reservationRequest);

    Reservation deleteReservation(Integer id);






}
