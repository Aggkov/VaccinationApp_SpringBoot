package com.example.demogroup.service;

import com.example.demogroup.payload.TimeslotResponse;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface TimeslotService {

    ResponseEntity<Set<TimeslotResponse>> findTimeslotsByVaccinationCenterId(Integer id);

    TimeslotResponse getTimeSlotByCenter(Integer centerId, Integer id);
}
