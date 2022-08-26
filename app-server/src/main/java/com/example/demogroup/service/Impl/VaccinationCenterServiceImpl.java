package com.example.demogroup.service.Impl;

import com.example.demogroup.exception.ResourceNotFoundException;
import com.example.demogroup.model.Timeslot;
import com.example.demogroup.model.VaccinationCenter;
import com.example.demogroup.payload.response.VaccinationCenterResponse;
import com.example.demogroup.payload.response.VaccinationCenterTimeslotsResponse;
import com.example.demogroup.repository.VaccinationCenterRepository;
import com.example.demogroup.service.VaccinationCenterService;
import com.example.demogroup.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    @Override
    public ResponseEntity<List<VaccinationCenterResponse>> getAllVaccinationCenters() {

        List<VaccinationCenter> centers = new ArrayList<>(vaccinationCenterRepository.findAll());

        List<VaccinationCenterResponse> centersResponse = ObjectMapperUtils.mapAll(centers, VaccinationCenterResponse.class);

        return new ResponseEntity<>(centersResponse, HttpStatus.OK);
    }

    @Override
    public VaccinationCenterTimeslotsResponse getVaccinationCenter(Integer id) {
        VaccinationCenter center = vaccinationCenterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vaccination Center with id = " + id + " was not found"));

        Set<Timeslot> timeslots = center.getTimeslots().stream()
                .sorted(Comparator.comparing(Timeslot::getStartTime))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        center.setTimeslots(timeslots);

        VaccinationCenterTimeslotsResponse vaccinationCenterTimeslotsResponse = ObjectMapperUtils.map(center, VaccinationCenterTimeslotsResponse.class);

        return vaccinationCenterTimeslotsResponse;

    }

    @Override
    public List<VaccinationCenterResponse> getAllVaccinationCentersByDate(LocalDate dateFrom, LocalDate dateTo) {

        dateTo = dateFrom.plusMonths(1);

        List<VaccinationCenter> centers = vaccinationCenterRepository.findAllCentersByDate(dateFrom, dateTo);

        List<VaccinationCenterResponse> vaccinationCenterResponseList = ObjectMapperUtils.mapAll(centers, VaccinationCenterResponse.class);

        return vaccinationCenterResponseList;
    }

    @Override
    public ResponseEntity<VaccinationCenter> addVaccinationCenter() {
        return null;
    }

//    @Override
//    public ResponseEntity<VaccinationCenter> updateVaccinationCenter(Integer id) {
//        return null;
//    }
}
