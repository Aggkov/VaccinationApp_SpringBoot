package com.example.demogroup.controller;

import com.example.demogroup.payload.TimeslotResponse;
import com.example.demogroup.service.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/timeslots")
public class TimeslotController {

    @Autowired
    TimeslotService timeslotService;

    @GetMapping("/{centerId}/{timeslotId}")
    public ResponseEntity<TimeslotResponse> getTimeSlotByCenter(@PathVariable(name = "centerId") Integer centerId,
                                                                @PathVariable(name = "timeslotId") Integer Id) {
        TimeslotResponse timeslotResponse = timeslotService.getTimeSlotByCenter(centerId, Id);

        return new ResponseEntity<>(timeslotResponse, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<List<TimeslotResponse>> getAllTimeslotsByVaccinationCenter(
            @PathVariable(name = "id") Integer id) {

        return timeslotService.getTimeslotsByVaccinationCenterId(id);

    }

}
