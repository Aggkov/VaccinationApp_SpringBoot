package com.example.demogroup.service;

import com.example.demogroup.model.dto.TimeslotDto;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface TimeSlotService {

    ResponseEntity<Set<TimeslotDto>> findTimeslotsByVaccinationCenterId(Integer id);
}
