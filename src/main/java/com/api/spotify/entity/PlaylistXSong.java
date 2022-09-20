package com.api.spotify.entity;

import javax.persistence.*;

@Entity
public class PlaylistXSong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn(name = "song", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Song song;

    @JoinColumn(name = "playlist", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Playlist playlist;

    public PlaylistXSong() {
    }

    public PlaylistXSong(Long id) {
        this.id = id;
    }

    public PlaylistXSong(Long id, Song song, Playlist playlist) {
        this.id = id;
        this.song = song;
        this.playlist = playlist;
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

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

}
