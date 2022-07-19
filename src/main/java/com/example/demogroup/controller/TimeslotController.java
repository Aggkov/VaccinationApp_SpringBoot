package com.example.demogroup.controller;

import com.example.demogroup.model.dto.TimeslotResponse;
import com.example.demogroup.service.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    TimeslotService timeslotService;

    @GetMapping("/{centerId}/{id}")
    public ResponseEntity<TimeslotResponse> getTimeSlotByCenter(@PathVariable(name = "centerId") Integer centerId,
                                                                @PathVariable(name = "id") Integer Id) {
        TimeslotResponse timeslotResponse = timeslotService.getTimeSlotByCenter(centerId, Id);

        return new ResponseEntity<>(timeslotResponse, HttpStatus.OK);
    }


    @GetMapping("{id}/timeslots")
    public ResponseEntity<Set<TimeslotResponse>> getAllTimeslotsByVaccinationCenter(
            @PathVariable(name = "id") Integer id) {

        return timeslotService.findTimeslotsByVaccinationCenterId(id);

    }
}
