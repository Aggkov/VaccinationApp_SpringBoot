package com.example.demogroup.model;

import com.example.demogroup.model.user.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
//@JsonSerialize
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rv_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_code")
//    @JsonManagedReference
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ts_code")
    @JsonManagedReference
    private Timeslot timeslot;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot tsCode) {
        this.timeslot = tsCode;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", userCode=" + user +
                ", tsCode=" + timeslot +
                '}';
    }
}
