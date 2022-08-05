package com.example.demogroup.repository;

import com.example.demogroup.model.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationRepository extends JpaRepository<Vaccination,Integer> {
}
