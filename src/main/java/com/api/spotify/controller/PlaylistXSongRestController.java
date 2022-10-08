package com.api.spotify.controller;

import com.api.spotify.entity.PlaylistXSong;
import com.api.spotify.service.PlaylistXSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/playlist_x_song")
public class PlaylistXSongRestController {

    @Autowired
    private PlaylistXSongService playlistXSongService;

    public PlaylistXSongRestController(PlaylistXSongService playlistXSongService) {
        this.playlistXSongService = playlistXSongService;
    }

    @GetMapping
    public List<PlaylistXSong> getList() {
        return playlistXSongService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<PlaylistXSong> getPlaylistXSong(@PathVariable Long id) {
        return playlistXSongService.getOne(id);
    }

    @PostMapping
    public ResponseEntity<PlaylistXSong> createPlaylistXSong(@RequestBody PlaylistXSong newPlaylistXSong) {
        return new ResponseEntity<>(playlistXSongService.save(newPlaylistXSong), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlaylistXSong> replacePlaylistXSong(@RequestBody PlaylistXSong newPlaylistXsong, @PathVariable Long id) {
        return new ResponseEntity<>(playlistXSongService.update(newPlaylistXsong, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePlaylistXSong(@PathVariable Long id) {
        playlistXSongService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
