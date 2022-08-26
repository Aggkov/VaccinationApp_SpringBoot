package com.example.demogroup.payload.response;

import com.example.demogroup.model.Timeslot;

import java.util.List;

public class VaccinationCenterTimeslotsResponse {

    private Integer id;

    private String address;

    private List<Timeslot> timeSlots;

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
