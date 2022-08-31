package com.example.demogroup.payload.request;

public class UserProfileUpdateRequest {

    private Integer Id;

    private String firstName;

    private String lastName;

    private String email;

    private String afm;

//    public UserProfileRequest(String firstName, String lastName, String email, String afm) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.afm = afm;
//    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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
