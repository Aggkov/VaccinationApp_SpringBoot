package com.example.demogroup.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @Column(name = "doc_afm", nullable = false)
    private Integer id;

    @Column(name = "doc_name", length = 45)
    private String docName;

    @Column(name = "doc_surname", length = 45)
    private String docSurname;

    @OneToMany(mappedBy = "docCode")
    private Set<Vaccination> vaccinations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "docCode")
    private Set<Timeslot> timeslots = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocSurname() {
        return docSurname;
    }

    public void setDocSurname(String docSurname) {
        this.docSurname = docSurname;
    }

    public Set<Vaccination> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(Set<Vaccination> vaccinations) {
        this.vaccinations = vaccinations;
    }

    public Set<Timeslot> getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(Set<Timeslot> timeslots) {
        this.timeslots = timeslots;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", docName='" + docName + '\'' +
                ", docSurname='" + docSurname + '\'' +
                ", vaccinations=" + vaccinations +
                ", timeslots=" + timeslots +
                '}';
    }
}