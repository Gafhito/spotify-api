package com.api.spotify.entity;

import javax.persistence.*;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "genre", nullable = false, length = 50)
    private String genre;

    public Genre() {
    }

    public Genre(Long id) {
        this.id = id;
    }

    public Genre(Long id, String genre) {
        this.id = id;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String country) {
        this.genre = country;
    }

}
