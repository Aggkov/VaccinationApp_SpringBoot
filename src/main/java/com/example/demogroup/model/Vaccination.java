package com.example.demogroup.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "vaccination")
public class Vaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacc_id", nullable = false)
    private Integer id;

    @Column(name = "vaccination_date")
    private Instant vaccinationDate;

    @Column(name = "expiration_date")
    private Instant expirationDate;

    @Column(name = "completed")
    private Integer completed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_code")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_code")
    private Doctor doctor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(Instant vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public Instant getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Instant expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vaccination{");
        sb.append("vaccinationDate=").append(vaccinationDate);
        sb.append(", expirationDate=").append(expirationDate);
        sb.append(", completed=").append(completed);
        sb.append(", userCode=").append(user);
        sb.append(", docCode=").append(doctor);
        sb.append('}');
        return sb.toString();
    }
}