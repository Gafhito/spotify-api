package com.api.spotify.entity;

import javax.persistence.*;

@Entity
public class GenreXSong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "song")
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Song song;

    @JoinColumn(name = "genre")
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Genre genre;

    public GenreXSong() {
    }

    public GenreXSong(Long id) {
        this.id = id;
    }

    public GenreXSong(Long id, Song song, Genre genre) {
        this.id = id;
        this.song = song;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

}
