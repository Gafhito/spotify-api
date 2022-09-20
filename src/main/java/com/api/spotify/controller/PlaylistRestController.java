package com.api.spotify.controller;

import com.api.spotify.entity.Playlist;
import com.api.spotify.service.PlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/playlist")
public class PlaylistRestController {

    private PlaylistService playlistService;

    public PlaylistRestController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping
    public List<Playlist> getList() {
        return playlistService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Playlist> getPlaylist(@PathVariable Long id) {
        return playlistService.getOne(id);
    }

    @PostMapping
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist newPlaylist) {
        return new ResponseEntity<>(playlistService.save(newPlaylist), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Playlist> replacePlaylist(@RequestBody Playlist newPlaylist, @PathVariable Long id) {
        return new ResponseEntity<>(playlistService.update(newPlaylist, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Playlist> deletePlaylist(@PathVariable Long id) {
        return new ResponseEntity<>(playlistService.delete(id), HttpStatus.OK);
    }

}
