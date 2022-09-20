package com.api.spotify.controller;

import com.api.spotify.entity.GenreXSong;
import com.api.spotify.service.GenreXSongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genre_x_song")
public class GenreXSongRestController {

    private GenreXSongService genreXSongService;

    public GenreXSongRestController(GenreXSongService genreXSongService) {
        this.genreXSongService = genreXSongService;
    }

    @GetMapping
    public List<GenreXSong> getList() {
        return genreXSongService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<GenreXSong> getGenreXSong(@PathVariable Long id) {
        return genreXSongService.getOne(id);
    }

    @PostMapping
    public ResponseEntity<GenreXSong> createGenreXSong(@RequestBody GenreXSong newGenreXSong) {
        return new ResponseEntity<>(genreXSongService.save(newGenreXSong), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreXSong> replaceGenreXSong(@RequestBody GenreXSong newGenreXsong, @PathVariable Long id) {
        return new ResponseEntity<>(genreXSongService.update(newGenreXsong, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGenreXSong(@PathVariable Long id) {
        genreXSongService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
