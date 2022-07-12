//package com.example.demogroup.model;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "vc_timeslot")
//public class VcTimeslot {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @EmbeddedId
//    private VcTimeslotId id;
//
//    @MapsId("vcCode")
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "vc_code", nullable = false)
//    private VaccinationCenter vaccinationCenter;
//
//    @MapsId("tsCode")
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "ts_code", nullable = false)
//    private Timeslot timeslot;
//
//    public VcTimeslotId getId() {
//        return id;
//    }
//
//    public void setId(VcTimeslotId id) {
//        this.id = id;
//    }
//
//    public VaccinationCenter getVaccinationCenter() {
//        return vaccinationCenter;
//    }
//
//    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
//        this.vaccinationCenter = vaccinationCenter;
//    }
//
//    public Timeslot getTimeslot() {
//        return timeslot;
//    }
//
//    public void setTimeslot(Timeslot timeslot) {
//        this.timeslot = timeslot;
//    }
//
//}