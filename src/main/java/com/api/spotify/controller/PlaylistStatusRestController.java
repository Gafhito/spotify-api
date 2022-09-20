package com.api.spotify.controller;

import com.api.spotify.entity.PlaylistStatus;
import com.api.spotify.repository.PlaylistStatusRepository;
import com.api.spotify.service.PlaylistStatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/playlist_status")
public class PlaylistStatusRestController {

    private PlaylistStatusRepository playlistStatusRepository;
    private PlaylistStatusService playlistStatusService;

    public PlaylistStatusRestController(PlaylistStatusRepository playlistStatusRepository, PlaylistStatusService playlistStatusService) {
        this.playlistStatusRepository = playlistStatusRepository;
        this.playlistStatusService = playlistStatusService;
    }

    @GetMapping
    public List<PlaylistStatus> getList() {
        return playlistStatusService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<PlaylistStatus> getPlaylistStatus(@PathVariable Long id) {
        return playlistStatusService.getOne(id);
    }

    @PostMapping
    public ResponseEntity<PlaylistStatus> createPlaylistStatus(@RequestBody PlaylistStatus newPlaylistStatus) {
        return new ResponseEntity<>(playlistStatusService.save(newPlaylistStatus), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlaylistStatus> replacePlaylistStatus(@RequestBody PlaylistStatus newPlaylistStatus, @PathVariable Long id) {
        return new ResponseEntity<>(playlistStatusService.update(newPlaylistStatus, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePlaylistStatus(@PathVariable Long id) {
        playlistStatusService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
