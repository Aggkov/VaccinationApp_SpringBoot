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
    private String firstName;

    @Column(name = "user_surname", length = 45)
    private String lastName;

    @Column(name = "user_email", length = 45)
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Reservation> reservations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Vaccination> vaccinations = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String userName) {
        this.firstName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String userSurname) {
        this.lastName = userSurname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String userEmail) {
        this.email = userEmail;
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