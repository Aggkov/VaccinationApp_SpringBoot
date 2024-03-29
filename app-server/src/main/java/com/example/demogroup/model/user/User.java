package com.example.demogroup.model.user;

import com.example.demogroup.model.Reservation;
import com.example.demogroup.model.role.Role;
import com.example.demogroup.model.Vaccination;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
//    @Id
//    @Column(name = "user_afm", nullable = false)
//    private Integer id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "firstname", length = 45)
    private String firstName;

    @Column(name = "lastname", length = 45)
    private String lastName;

    @Column(name = "user_afm")
    private String userAfm;

    @Column(name = "user_email", length = 45)
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany
            (mappedBy = "user",
            fetch = FetchType.LAZY)
//    @JsonBackReference
    private Set<Reservation> reservations = new LinkedHashSet<>();

    @OneToMany
            (mappedBy = "user" ,fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Vaccination> vaccinations = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
        joinColumns = @JoinColumn(name = "user_code"),
        inverseJoinColumns = @JoinColumn(name = "role_code"))
    private Set<Role> roles = new LinkedHashSet<>();

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

    public String getUserAfm() {
        return userAfm;
    }

    public void setUserAfm(String userAfm) {
        this.userAfm = userAfm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String userEmail) {
        this.email = userEmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userAfm='" + userAfm + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
