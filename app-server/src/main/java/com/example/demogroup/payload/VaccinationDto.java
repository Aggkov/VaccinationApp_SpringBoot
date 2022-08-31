package com.example.demogroup.payload;

import java.time.LocalDate;

public class VaccinationDto {

    private Integer id;
    private LocalDate vaccinationDate;
    private LocalDate expirationDate;
//    private UserResponse user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

//    public UserResponse getUser() {
//        return user;
//    }
//
//    public void setUser(UserResponse user) {
//        this.user = user;
//    }

}
