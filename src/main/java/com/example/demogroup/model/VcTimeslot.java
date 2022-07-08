package com.example.demogroup.model;

import javax.persistence.*;

@Entity
@Table(name = "vc_timeslot")
public class VcTimeslot {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private VcTimeslotId id;

    @MapsId("vcCode")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vc_code", nullable = false)
    private VaccinationCenter vcCode;

    @MapsId("tsCode")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ts_code", nullable = false)
    private Timeslot tsCode;

    public VcTimeslotId getId() {
        return id;
    }

    public void setId(VcTimeslotId id) {
        this.id = id;
    }

    public VaccinationCenter getVcCode() {
        return vcCode;
    }

    public void setVcCode(VaccinationCenter vcCode) {
        this.vcCode = vcCode;
    }

    public Timeslot getTsCode() {
        return tsCode;
    }

    public void setTsCode(Timeslot tsCode) {
        this.tsCode = tsCode;
    }

}