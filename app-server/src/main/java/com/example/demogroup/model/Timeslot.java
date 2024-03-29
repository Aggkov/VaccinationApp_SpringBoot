package com.example.demogroup.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "timeslot")
public class Timeslot implements Comparable<Timeslot> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ts_id", nullable = false)
    private Integer id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "available")
    private Integer available;

    @OneToMany(mappedBy = "timeslot", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Reservation> reservations = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "vc_timeslot",
            joinColumns = @JoinColumn(name = "ts_code"),
            inverseJoinColumns = @JoinColumn(name = "vc_code"))
    @JsonBackReference
    private Set<VaccinationCenter> vaccinationCenters = new LinkedHashSet<>();

    @Override
    public int compareTo(Timeslot o) {
        return o.getId().compareTo(this.getId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }


    public Set<VaccinationCenter> getVaccinationCenters() {
        return vaccinationCenters;
    }

    public void setVaccinationCenters(Set<VaccinationCenter> vaccinationCenters) {
        this.vaccinationCenters = vaccinationCenters;
    }
}