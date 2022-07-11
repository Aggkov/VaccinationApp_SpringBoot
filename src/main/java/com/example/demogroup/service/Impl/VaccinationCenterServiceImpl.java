package com.example.demogroup.service.Impl;

import com.example.demogroup.model.VaccinationCenter;
import com.example.demogroup.model.dto.VaccinationCentersDto;
import com.example.demogroup.repository.VaccinationCenterRepository;
import com.example.demogroup.service.VaccinationCenterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//import static jdk.nashorn.internal.objects.NativeDebug.map;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseEntity<List<VaccinationCentersDto>> getAllVaccinationCenters() {

        List<VaccinationCenter> centers = new ArrayList<>(vaccinationCenterRepository.findAll());

        List<VaccinationCentersDto> centersDto = centers.stream()
                .map(center -> map(center, VaccinationCentersDto.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(centersDto, HttpStatus.OK);
    }

    public <D, T> D map(final T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }

    @Override
    public ResponseEntity<VaccinationCenter> addVaccinationCenter() {
        return null;
    }

    @Override
    public ResponseEntity<VaccinationCenter> getVaccinationCenter(Integer id) {
        return null;
    }

//    @Override
//    public ResponseEntity<VaccinationCenter> updateVaccinationCenter(Integer id) {
//        return null;
//    }
}
