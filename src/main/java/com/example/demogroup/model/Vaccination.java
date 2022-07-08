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
    private User userCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_code")
    private Doctor docCode;

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

    public User getUserCode() {
        return userCode;
    }

    public void setUserCode(User userCode) {
        this.userCode = userCode;
    }

    public Doctor getDocCode() {
        return docCode;
    }

    public void setDocCode(Doctor docCode) {
        this.docCode = docCode;
    }

}