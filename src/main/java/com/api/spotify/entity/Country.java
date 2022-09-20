package com.api.spotify.entity;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "country", nullable = false, length = 50)
    private String country;

    public Country() {
    }

    public Country(Long id) {
        this.id = id;
    }

    public Country(Long id, String country) {
        this.id = id;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
