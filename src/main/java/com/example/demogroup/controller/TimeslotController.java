package com.example.demogroup.controller;

import com.example.demogroup.model.dto.TimeslotDto;
import com.example.demogroup.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/timeslot")
public class TimeslotController {

    @Autowired
    TimeSlotService timeslotService;

    @GetMapping("{id}/timeslots")
    public ResponseEntity<Set<TimeslotDto>> getAllTimeslotsByVaccinationCenter(
            @PathVariable(name = "id") Integer id) {

        return timeslotService.findTimeslotsByVaccinationCenterId(id);

    }
}
