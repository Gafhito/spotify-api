package com.api.spotify.entity;

import javax.persistence.*;

@Entity
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @JoinColumn(name = "discography", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Discography discography;

    @JoinColumn(name = "artist", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Artist artist;

    @Column(name = "cover_image", length = 50)
    private String coverImage;

    public Album() {
    }

    public Album(Long id) {
        this.id = id;
    }

    public Album(Long id, String title, Discography discography, Artist artist, String coverImage) {
        this.id = id;
        this.title = title;
        this.discography = discography;
        this.artist = artist;
        this.coverImage = coverImage;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Discography getDiscography() {
        return discography;
    }

    public void setDiscography(Discography discography) {
        this.discography = discography;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

}
