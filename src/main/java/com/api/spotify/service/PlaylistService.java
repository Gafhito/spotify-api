package com.api.spotify.service;

import com.api.spotify.entity.Playlist;
import com.api.spotify.repository.PlaylistRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    private PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public List<Playlist> getAll() {
        return playlistRepository.findAll();
    }

    public Optional<Playlist> getOne(Long id) {
        return playlistRepository.findById(id);
    }

    public Playlist save(Playlist newPlaylist) {
        return playlistRepository.save(newPlaylist);
    }

    public Playlist update(Playlist newPlaylist, Long id) {
        return playlistRepository.findById(id).map(
                playlist -> {
                    playlist.setUser(newPlaylist.getUser());
                    playlist.setTitle(newPlaylist.getTitle());
                    playlist.setNumberSongs(newPlaylist.getNumberSongs());
                    playlist.setStatus(newPlaylist.getStatus());
                    return playlist;
                }
        ).get();
    }

    public Playlist delete(Long id) {
        return playlistRepository.findById(id).map(
                playlist -> {
                    playlist.setDateDeleted(LocalDateTime.now());
                    return playlist;
                }
        ).get();
    }

}
