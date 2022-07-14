package com.example.demogroup.repository;

import com.example.demogroup.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    public Doctor getDoctorById(Integer id);

    public boolean existsDoctorById(Integer id);

}
