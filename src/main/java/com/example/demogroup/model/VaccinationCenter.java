package com.example.demogroup.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "vaccination_center")
public class VaccinationCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vc_id", nullable = false)
    private Integer id;

    @Column(name = "address", length = 45)
    private String address;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "vc_timeslot",
            joinColumns = @JoinColumn(name = "vc_code"),
            inverseJoinColumns = @JoinColumn(name = "ts_code"))
    private Set<Timeslot> timeslots = new LinkedHashSet<>();

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

//    @JsonManagedReference
    public Set<Timeslot> getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(Set<Timeslot> timeslots) {
        this.timeslots = timeslots;
    }

}