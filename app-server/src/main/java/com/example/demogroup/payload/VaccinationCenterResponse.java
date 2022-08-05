package com.example.demogroup.payload;

public class VaccinationCenterResponse {

    private Integer id;

    private String address;

//    private List<Timeslot> timeSlots;

    public VaccinationCenterResponse() {
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

//    public List<Timeslot> getTimeSlots() {
//        return timeSlots;
//    }
//
//    public void setTimeSlots(List<Timeslot> timeSlots) {
//        this.timeSlots = timeSlots;
//    }

}
