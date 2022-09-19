package com.api.spotify.entity;

import javax.persistence.*;

@Entity
@Table(name = "artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    public Artist() {
    }

    public Artist(Long id) {
        this.id = id;
    }

    public Artist(Long id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
