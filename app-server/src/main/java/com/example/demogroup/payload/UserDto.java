package com.example.demogroup.payload;

public class UserDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String userAfm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUserAfm() {
        return userAfm;
    }

    public void setUserAfm(String userAfm) {
        this.userAfm = userAfm;
    }
}
