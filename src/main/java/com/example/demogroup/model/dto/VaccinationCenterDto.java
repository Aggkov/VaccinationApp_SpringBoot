package com.example.demogroup.model.dto;

import com.example.demogroup.model.Timeslot;

import java.util.List;

public class VaccinationCenterDto {

    private Integer id;

    private String address;

    private List<Timeslot> timeSlots;

    public VaccinationCenterDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Timeslot> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<Timeslot> timeSlots) {
        this.timeSlots = timeSlots;
    }
}
