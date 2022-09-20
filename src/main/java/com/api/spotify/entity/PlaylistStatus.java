package com.api.spotify.entity;

import javax.persistence.*;

@Entity
@Table(name = "playlist_status")
public class PlaylistStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description", nullable = false, length = 50)
    private String description;

    public PlaylistStatus() {
    }

    public PlaylistStatus(Long id) {
        this.id = id;
    }

    public PlaylistStatus(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
