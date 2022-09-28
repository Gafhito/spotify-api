package com.api.spotify.service;

import com.api.spotify.entity.PlaylistStatus;
import com.api.spotify.repository.PlaylistStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistStatusService {

    private PlaylistStatusRepository playlistStatusRepository;

    public PlaylistStatusService(PlaylistStatusRepository playlistStatusRepository) {
        this.playlistStatusRepository = playlistStatusRepository;
    }

    public List<PlaylistStatus> getAll() {
        return playlistStatusRepository.findAll();
    }

    public Optional<PlaylistStatus> getOne(Long id) {
        return playlistStatusRepository.findById(id);
    }

    public PlaylistStatus save(PlaylistStatus newPlaylistStatus) {
        return playlistStatusRepository.save(newPlaylistStatus);
    }

    public PlaylistStatus update(PlaylistStatus newPlaylistStatus, Long id) {
        return playlistStatusRepository.findById(id).map(
                playlistStatus -> {
                    playlistStatus.setDescription(newPlaylistStatus.getDescription());
                    return playlistStatusRepository.save(playlistStatus);
                }
        ).get();
    }

    public void delete(Long id) {
        playlistStatusRepository.deleteById(id);
    }

}
