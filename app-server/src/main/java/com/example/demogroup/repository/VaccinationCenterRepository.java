package com.example.demogroup.repository;

import com.example.demogroup.model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter,Integer> {

    @Query("SELECT distinct vaccinationcenter " +
            " FROM VaccinationCenter vaccinationcenter " +
            " JOIN vaccinationcenter.timeslots timeslot " +
//            " JOIN timeslot.startDate startdate " +
            " WHERE timeslot.startDate BETWEEN ?1 AND ?2")
     List<VaccinationCenter> findAllCentersByDate(@Param("dateFrom") LocalDate dateFrom, LocalDate dateTo);

}