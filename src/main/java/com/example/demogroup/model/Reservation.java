package com.example.demogroup.model;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rv_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_code")
    private User userCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ts_code")
    private Timeslot tsCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUserCode() {
        return userCode;
    }

    public void setUserCode(User userCode) {
        this.userCode = userCode;
    }

    public Timeslot getTsCode() {
        return tsCode;
    }

    public void setTsCode(Timeslot tsCode) {
        this.tsCode = tsCode;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", userCode=" + userCode +
                ", tsCode=" + tsCode +
                '}';
    }
}
