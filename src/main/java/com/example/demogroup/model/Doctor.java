package com.example.demogroup.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @Column(name = "doc_afm", nullable = false)
    private Integer id;

    @Column(name = "doc_name", length = 45)
    private String firstName;

    @Column(name = "doc_surname", length = 45)
    private String lastName;

    @OneToMany(mappedBy = "doctor" ,fetch = FetchType.LAZY)
    private Set<Vaccination> vaccinations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "doctor" ,fetch = FetchType.LAZY)
    private Set<Timeslot> timeslots = new LinkedHashSet<>();

    public Doctor() {
    }

    public Doctor(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String docName) {
        this.firstName = docName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String docSurname) {
        this.lastName = docSurname;
    }

    public Set<Vaccination> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(Set<Vaccination> vaccinations) {
        this.vaccinations = vaccinations;
    }

    public Set<Timeslot> getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(Set<Timeslot> timeslots) {
        this.timeslots = timeslots;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", docName='" + firstName + '\'' +
                ", docSurname='" + lastName + '\'' +
                ", vaccinations=" + vaccinations +
                ", timeslots=" + timeslots +
                '}';
    }
}