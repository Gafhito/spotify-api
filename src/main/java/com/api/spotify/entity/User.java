package com.api.spotify.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", length = 50, nullable = false)
    private String username;

    @Column(name = "first_and_lastname", length = 50, nullable = false)
    private String firstAndLastname;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "gender", length = 1, nullable = false)
    private Character gender;

    @Column(name = "zipcode", length = 8, nullable = false)
    private String zipcode;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @JoinColumn(name = "country", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Country country;

    @JoinColumn(name = "user_type", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserType userType;

    @Column(name = "password_date")
    private LocalDate passwordDate;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String username, String firstAndLastname, LocalDate birthdate, Character gender, String zipcode, String password, Country country, UserType userType) {
        this.id = id;
        this.username = username;
        this.firstAndLastname = firstAndLastname;
        this.birthdate = birthdate;
        this.gender = gender;
        this.zipcode = zipcode;
        this.password = password;
        this.country = country;
        this.userType = userType;
        this.passwordDate = null;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstAndLastname() {
        return firstAndLastname;
    }

    public void setFirstAndLastname(String firstAndLastname) {
        this.firstAndLastname = firstAndLastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public LocalDate getPasswordDate() {
        return passwordDate;
    }

    public void setPasswordDate(LocalDate passwordDate) {
        this.passwordDate = passwordDate;
    }

}
