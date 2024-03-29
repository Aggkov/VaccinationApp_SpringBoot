package com.example.demogroup.repository;

import com.example.demogroup.model.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSlotRepository extends JpaRepository<Timeslot, Integer> {


}
