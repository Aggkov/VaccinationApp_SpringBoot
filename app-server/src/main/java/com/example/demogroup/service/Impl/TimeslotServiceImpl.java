package com.example.demogroup.service.Impl;

import com.example.demogroup.exception.ResourceNotFoundException;
import com.example.demogroup.model.Timeslot;
import com.example.demogroup.model.VaccinationCenter;
import com.example.demogroup.payload.TimeslotResponse;
import com.example.demogroup.repository.TimeSlotRepository;
import com.example.demogroup.repository.VaccinationCenterRepository;
import com.example.demogroup.service.TimeslotService;
import com.example.demogroup.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class TimeslotServiceImpl implements TimeslotService {

    @Autowired
    TimeSlotRepository timeSlotRepository;

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    @Override
    public TimeslotResponse getTimeSlotByCenter(Integer centerId, Integer id) {

        VaccinationCenter center = vaccinationCenterRepository.findById(centerId)
                .orElseThrow(() -> new ResourceNotFoundException("Vaccination center with this id " + centerId +
                        "does not exist"));

        Timeslot timeslot = timeSlotRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("this timeslot with id doesnt exist"));

        TimeslotResponse timeslotResponse = new TimeslotResponse();
        if(center.getTimeslots().contains(timeslot)) {
            timeslotResponse = ObjectMapperUtils.map(timeslot, TimeslotResponse.class);

        }
        return timeslotResponse;
    }

    /**
     *
     * @param id  VaccinationCenter id
     * @return    Returns a Set of custom TimeSlot Objects (DTO)
     */
    @Override
    public ResponseEntity<List<TimeslotResponse>> findTimeslotsByVaccinationCenterId(Integer id) {

        VaccinationCenter center = vaccinationCenterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vaccination Center with id = " + id + "was not found"));

        List<Timeslot> timeslotsByCenter = new ArrayList<>(center.getTimeslots());
        Collections.sort(timeslotsByCenter, new Comparator() {
            public int compare (Object o1, Object o2){
                Timeslot timeslot1 = (Timeslot)o1;
                Timeslot timeslot2 = (Timeslot)o2;
                return timeslot1.getId().compareTo(timeslot2.getId());
            }
        });

        List<TimeslotResponse> timeslotResponse = ObjectMapperUtils.mapAll(timeslotsByCenter, TimeslotResponse.class);

        return new ResponseEntity<>(timeslotResponse, HttpStatus.OK);
    }
}
