package com.api.spotify.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn(name = "user")
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "number_songs", nullable = false)
    private Integer numberSongs;

    @JoinColumn(name = "status", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PlaylistStatus status;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @Column(name = "date_deleted")
    private LocalDateTime dateDeleted;

    public Playlist() {
    }

    public Playlist(Long id) {
        this.id = id;
    }

    public Playlist(Long id, User user, String title, Integer numberSongs, PlaylistStatus status) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.numberSongs = numberSongs;
        this.status = status;
        this.dateCreated = LocalDateTime.now();
        this.dateDeleted = null;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumberSongs() {
        return numberSongs;
    }

    public void setNumberSongs(Integer numberSongs) {
        this.numberSongs = numberSongs;
    }

    public PlaylistStatus getStatus() {
        return status;
    }

    public void setStatus(PlaylistStatus status) {
        this.status = status;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public LocalDateTime getDateDeleted() {
        return dateDeleted;
    }

    public void setDateDeleted(LocalDateTime dateDeleted) {
        this.dateDeleted = dateDeleted;
    }

}
