package com.example.demogroup.service.Impl;

import com.example.demogroup.exception.ReservationException;
import com.example.demogroup.exception.ResourceNotFoundException;
import com.example.demogroup.model.Reservation;
import com.example.demogroup.model.Timeslot;
import com.example.demogroup.model.user.User;
import com.example.demogroup.payload.request.ReservationRequest;
import com.example.demogroup.payload.response.ReservationResponse;
import com.example.demogroup.repository.ReservationRepository;
import com.example.demogroup.repository.TimeSlotRepository;
import com.example.demogroup.repository.UserRepository;
import com.example.demogroup.security.UserPrincipal;
import com.example.demogroup.service.ReservationService;
import com.example.demogroup.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    private final int totalAllowedReservations = 2;

    @Override
    public ResponseEntity<List<ReservationResponse>> getAllReservations() {

        List<Reservation> reservations = new ArrayList<>(reservationRepository.findAll());

        List<ReservationResponse> reservationResponse = ObjectMapperUtils.mapAll(reservations, ReservationResponse.class);
        return new ResponseEntity<>(reservationResponse, HttpStatus.OK);

    }

    @Override
    @Transactional
    public ResponseEntity<ReservationResponse> addReservation(UserPrincipal userPrincipal, Integer timeslotId) {

        User user = userRepository.findById(userPrincipal.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("user was not found with this id"));

        Timeslot timeslot = timeSlotRepository.findById(timeslotId)
                .orElseThrow(() -> new ResourceNotFoundException("timeslot was not found with this id"));

        Long currentReservationCountInTimeSlot = timeslot.getReservations()
                .stream()
                .count();


        if(user.getReservations().size() == 0) {
            if(currentReservationCountInTimeSlot < totalAllowedReservations) {
                Reservation reservation = new Reservation();

                reservation.setUser(user);
                reservation.setTimeslot(timeslot);

                Reservation newReservation = reservationRepository.save(reservation);

                // check if with new reservation the timeslot will be set to unavailable
                Long newReservationCountInTimeSlot = timeslot.getReservations()
                        .stream()
                        .count();
                if(newReservationCountInTimeSlot == totalAllowedReservations) {
                    timeslot.setAvailable(0);
                }
                else {
                    ReservationResponse reservationResponse = ObjectMapperUtils.map(newReservation, ReservationResponse.class);
                    return new ResponseEntity<>(reservationResponse, HttpStatus.CREATED);
                }
            }
            throw new ReservationException("TimeSlot with Id " + timeslot.getId() + " has reached its maximum reservation number");
        }

        throw new ReservationException("User has already done a reservation");

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
