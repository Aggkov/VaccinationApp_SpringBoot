package com.example.demogroup.service;

import com.example.demogroup.payload.TimeslotResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TimeslotService {

    ResponseEntity<List<TimeslotResponse>> findTimeslotsByVaccinationCenterId(Integer id);

    TimeslotResponse getTimeSlotByCenter(Integer centerId, Integer id);
}
