package com.example.demogroup.service.Impl;

import com.example.demogroup.exception.ResourceNotFoundException;
import com.example.demogroup.exception.VaccinationException;
import com.example.demogroup.model.Reservation;
import com.example.demogroup.model.Vaccination;
import com.example.demogroup.model.role.ERole;
import com.example.demogroup.model.user.User;
import com.example.demogroup.payload.VaccinationResponse;
import com.example.demogroup.repository.ReservationRepository;
import com.example.demogroup.repository.UserRepository;
import com.example.demogroup.repository.VaccinationRepository;
import com.example.demogroup.security.UserPrincipal;
import com.example.demogroup.service.QrCodeService;
import com.example.demogroup.service.VaccinationService;
import com.example.demogroup.utils.DateUtils;
import com.example.demogroup.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VaccinationServiceImpl implements VaccinationService {

    @Autowired
    private VaccinationRepository vaccinationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    QrCodeService qrCodeService;

    @Override
    public ResponseEntity<List<VaccinationResponse>> getAllVaccinations() {
        List<Vaccination> vaccinations = new ArrayList<>(vaccinationRepository.findAll());

//        List<VaccinationResponse> vaccinationResponse = vaccinations.stream()
//                .map(vaccination -> modelMapper.map(vaccination , VaccinationResponse.class))
//                .collect(Collectors.toList());

        List<VaccinationResponse> vaccinationResponse = ObjectMapperUtils.mapAll(vaccinations, VaccinationResponse.class);

        return new ResponseEntity<>(vaccinationResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<byte[]> createVaccination(UserPrincipal userPrincipal, Integer reservationId) {

        User user = userRepository.findById(userPrincipal.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("user was not found with this id" + userPrincipal.getUser().getId()));

        if(userPrincipal.getAuthorities().contains(new SimpleGrantedAuthority(ERole.ROLE_DOCTOR.toString())) ||
        userPrincipal.getAuthorities().contains(new SimpleGrantedAuthority(ERole.ROLE_ADMIN.toString()))) {

            Reservation reservation = reservationRepository.findById(reservationId)
                    .orElseThrow(() -> new ResourceNotFoundException("Reservation was not found with this id " + reservationId));

            if(reservation.getUser().getVaccinations().size() == 0) {

                Vaccination vaccination = new Vaccination();
                vaccination.setVaccinationDate(reservation.getTimeslot().getStartDate());
                vaccination.setUser(reservation.getUser());

                vaccination.setExpirationDate(DateUtils.addSixMonthsToDate(reservation.getTimeslot().getStartDate()));
                System.out.println(vaccination.getExpirationDate());

                vaccination.setCompleted(1);

                vaccinationRepository.save(vaccination);

                String qrContent = vaccination.toString();
                byte[] qrCode = qrCodeService.generateQRCode(qrContent, 100,100);

                //                return new ResponseEntity<>(ObjectMapperUtils.map(vaccination, VaccinationResponse.class), HttpStatus.CREATED);
                return new ResponseEntity<>(qrCode, HttpStatus.CREATED);

            }
            throw new VaccinationException("User is already vaccinated");
        }
        throw new AccessDeniedException("Access is Forbidden");
    }


}
