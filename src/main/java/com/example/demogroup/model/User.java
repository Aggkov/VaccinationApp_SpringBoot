package com.example.demogroup.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_afm", nullable = false)
    private Integer id;

    @Column(name = "user_name", length = 45)
    private String userName;

    @Column(name = "user_surname", length = 45)
    private String userSurname;

    @Column(name = "user_email", length = 45)
    private String userEmail;

    @OneToMany(mappedBy = "userCode")
    private Set<Reservation> reservations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "userCode")
    private Set<Vaccination> vaccinations = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Set<Vaccination> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(Set<Vaccination> vaccinations) {
        this.vaccinations = vaccinations;
    }

}