package com.example.demogroup.payload.response;

public class UserProfileResponse {

    private String firstName;

    private String lastName;

    private String email;

    private String afm;

    public UserProfileResponse(String firstName, String lastName, String email, String afm) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.afm = afm;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }
}
