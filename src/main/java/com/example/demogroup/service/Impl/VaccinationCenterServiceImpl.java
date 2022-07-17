package com.example.demogroup.service.Impl;

import com.example.demogroup.exception.ResourceNotFoundException;
import com.example.demogroup.model.Timeslot;
import com.example.demogroup.model.VaccinationCenter;
import com.example.demogroup.model.dto.VaccinationCenterDto;
import com.example.demogroup.repository.VaccinationCenterRepository;
import com.example.demogroup.service.VaccinationCenterService;
import com.example.demogroup.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    @Override
    public ResponseEntity<List<VaccinationCenterDto>> getAllVaccinationCenters() {

        List<VaccinationCenter> centers = new ArrayList<>(vaccinationCenterRepository.findAll());

//         = centers.stream()
//                .map(center -> ObjectMapperUtils.map(center, VaccinationCenterDto.class))
//                .collect(Collectors.toList());
        List<VaccinationCenterDto> centersDto = ObjectMapperUtils.mapAll(centers,VaccinationCenterDto.class);

        return new ResponseEntity<>(centersDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VaccinationCenter> addVaccinationCenter() {
        return null;
    }


    @Override
    public VaccinationCenterDto getVaccinationCenter(Integer id) {
        VaccinationCenter center = vaccinationCenterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vaccination Center with id = " + id + " was not found"));

        List<Timeslot> timeslots = new ArrayList<>(center.getTimeslots());
        Collections.sort(timeslots);

//        Set<Timeslot> timeslotSet = new HashSet<>(timeslots);
//
//        center.setTimeslots(timeslotSet);
        System.out.println(timeslots);
//            public int compare (Object o1, Object o2){
//                Timeslot timeslot1 = (Timeslot)o1;
//                Timeslot timeslot2 = (Timeslot)o2;
//                return timeslot2.getId().compareTo(timeslot1.getId());
//            }
        ;

        VaccinationCenterDto centerDto = ObjectMapperUtils.map(center, VaccinationCenterDto.class);

        return centerDto;
    }

    @Override
    public List<VaccinationCenterDto> getAllVaccinationCentersByDate(LocalDate dateFrom, LocalDate dateTo) {

        dateTo = dateFrom.plusMonths(1);

        List<VaccinationCenter> centers = vaccinationCenterRepository.findAllCentersByDate(dateFrom, dateTo);
//        List<Timeslot> timeslots = new ArrayList<>(centers.getTimeslots());
//        List<Timeslot> timeslotSet = (List<Timeslot>) centers.stream()
//                        .flatMap(center -> center.getTimeslots()
//                                .stream().Collections.sort().collect(Collectors.toList()));
//        Collections.sort(timeslots);

//         = centers.stream()
//                .map(c -> ObjectMapperUtils.map(c, ))
//                .collect(Collectors.toList());

        List<VaccinationCenterDto> centerDtos = ObjectMapperUtils.mapAll(centers, VaccinationCenterDto.class);


        return centerDtos;
    }

//    @Override
//    public ResponseEntity<VaccinationCenter> updateVaccinationCenter(Integer id) {
//        return null;
//    }
}
