package com.example.demogroup.service;

import com.example.demogroup.model.Reservation;
import com.example.demogroup.model.dto.ReservationDto;

import java.util.List;

public interface ReservationService {

    List<Reservation> getAllReservations();

    Reservation addReservation(ReservationDto reservationDto);

    Reservation getReservation(Integer id);

    Reservation updateReservation(Integer id, ReservationDto reservationDto);

    Reservation deleteReservation(Integer id);






}
