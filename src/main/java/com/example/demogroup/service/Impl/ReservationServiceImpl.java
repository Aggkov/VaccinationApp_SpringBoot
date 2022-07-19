package com.example.demogroup.service.Impl;

import com.example.demogroup.exception.ResourceNotFoundException;
import com.example.demogroup.model.Reservation;
import com.example.demogroup.model.Timeslot;
import com.example.demogroup.model.User;
import com.example.demogroup.model.dto.ReservationRequest;
import com.example.demogroup.repository.ReservationRepository;
import com.example.demogroup.repository.TimeSlotRepository;
import com.example.demogroup.repository.UserRepository;
import com.example.demogroup.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TimeSlotRepository timeSlotRepository;

    @Override
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();

        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @Override
    public Reservation addReservation(Integer userId, Integer timeslotId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user was not found with this id"));

        Timeslot timeslot = timeSlotRepository.findById(timeslotId)
                .orElseThrow(() -> new ResourceNotFoundException("timeslot was not found with this id"));

        Reservation reservation = new Reservation();
        if(timeslot.getAvailable() != 0) {
            reservation.setUser(user);
            timeslot.setAvailable(0);
            reservation.setTimeslot(timeslot);
            return reservationRepository.save(reservation);
        }
        return null;
    }

    @Override
    public Reservation getReservation(Integer id) {
        return null;
    }

    @Override
    public Reservation updateReservation(Integer id, ReservationRequest reservationRequest) {
        return null;
    }

    @Override
    public Reservation deleteReservation(Integer id) {
        return null;
    }
}
