package com.example.demogroup.model.dto;

import com.example.demogroup.model.Timeslot;
import com.example.demogroup.model.User;

public class ReservationResponse {

    private Integer id;

    private UserDto user;

    private TimeslotResponse timeslot;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public TimeslotResponse getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(TimeslotResponse timeslot) {
        this.timeslot = timeslot;
    }
}
