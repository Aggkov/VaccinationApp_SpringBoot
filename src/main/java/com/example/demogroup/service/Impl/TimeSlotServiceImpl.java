package com.example.demogroup.service.Impl;

import com.example.demogroup.exception.ResourceNotFoundException;
import com.example.demogroup.model.Timeslot;
import com.example.demogroup.model.VaccinationCenter;
import com.example.demogroup.model.dto.TimeslotDto;
import com.example.demogroup.repository.TimeSlotRepository;
import com.example.demogroup.repository.VaccinationCenterRepository;
import com.example.demogroup.service.TimeSlotService;
import com.example.demogroup.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TimeSlotServiceImpl implements TimeSlotService {

    @Autowired
    TimeSlotRepository timeSlotRepository;

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    /**
     *
     * @param id  VaccinationCenter id
     * @return    Returns a Set of custom TimeSlot Objects (DTO)
     */
    @Override
    public ResponseEntity<Set<TimeslotDto>> findTimeslotsByVaccinationCenterId(Integer id) {

        VaccinationCenter center = vaccinationCenterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vaccination Center with id = " + id + "was not found"));

        List<Timeslot> timeslotsByCenter = new ArrayList<>(center.getTimeslots());
        Collections.sort(timeslotsByCenter, new Comparator() {
            public int compare (Object o1, Object o2){
                Timeslot p1 = (Timeslot)o1;
                Timeslot p2 = (Timeslot)o2;
                return p2.getId().compareTo(p1.getId());
            }
        });

        Set<TimeslotDto> timeslotDtosByCenter = timeslotsByCenter.stream()
                .map(c -> ObjectMapperUtils.map(c, TimeslotDto.class))

                .collect(Collectors.toSet());


        return new ResponseEntity<>(timeslotDtosByCenter, HttpStatus.OK);
    }
}
