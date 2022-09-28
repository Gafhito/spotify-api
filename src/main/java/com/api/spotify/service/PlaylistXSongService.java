package com.api.spotify.service;

import com.api.spotify.entity.PlaylistXSong;
import com.api.spotify.repository.PlaylistXSongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistXSongService {

    private PlaylistXSongRepository playlistXSongRepository;

    public List<PlaylistXSong> getAll() {
        return playlistXSongRepository.findAll();
    }

    public Optional<PlaylistXSong> getOne(Long id) {
        return playlistXSongRepository.findById(id);
    }

    public PlaylistXSong save(PlaylistXSong newPlaylistXSong) {
        return playlistXSongRepository.save(newPlaylistXSong);
    }

    public PlaylistXSong update(PlaylistXSong newPlaylistXSong, Long id) {
        return playlistXSongRepository.findById(id).map(
                playlistXSong -> {
                    playlistXSong.setSong(newPlaylistXSong.getSong());
                    playlistXSong.setPlaylist(newPlaylistXSong.getPlaylist());
                    return playlistXSongRepository.save(playlistXSong);
                }
        ).get();
    }

    public void delete(Long id) {
        playlistXSongRepository.deleteById(id);
    }

}
