package com.api.spotify.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "duration", nullable = false)
    private Double duration;

    @Column(name = "playback_amount")
    private String playbackAmount;

    @Column(name = "likes")
    private String likes;

    @JoinColumn(name = "album", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Album album;

    public Song() {
    }

    public Song(Long id) {
        this.id = id;
    }

    public Song(Long id, String title, double duration, Album album) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.playbackAmount = null;
        this.likes = null;
        this.album = album;
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

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getPlaybackAmount() {
        return playbackAmount;
    }

    public void setPlaybackAmount(String playbackAmount) {
        this.playbackAmount = playbackAmount;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

}
