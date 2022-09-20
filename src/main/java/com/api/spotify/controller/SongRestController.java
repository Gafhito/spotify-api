package com.api.spotify.controller;

import com.api.spotify.entity.Song;
import com.api.spotify.service.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/song")
public class SongRestController {

    private SongService songService;

    public SongRestController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public List<Song> getList() {
        return songService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Song> getSong(@PathVariable Long id) {
        return songService.getOne(id);
    }

    @PostMapping
    public ResponseEntity<Song> createSong(@RequestBody Song newSong) {
        return new ResponseEntity<>(songService.save(newSong), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Song> replaceSong(@RequestBody Song newSong, @PathVariable Long id) {
        return new ResponseEntity<>(songService.update(newSong, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSong(@PathVariable Long id) {
        songService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
