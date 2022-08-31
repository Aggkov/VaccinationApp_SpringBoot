package com.example.demogroup.payload.response;

import com.example.demogroup.model.user.User;
import com.example.demogroup.payload.TimeslotResponse;

public class ReservationResponse {

    private User user;

    private TimeslotResponse timeslot;

    public String getUser() {
        return user.getLastName() + " " + user.getFirstName();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TimeslotResponse getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(TimeslotResponse timeslot) {
        this.timeslot = timeslot;
    }
}
