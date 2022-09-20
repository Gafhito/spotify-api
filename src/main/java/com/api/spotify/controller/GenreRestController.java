package com.api.spotify.controller;

import com.api.spotify.entity.Genre;
import com.api.spotify.repository.GenreRepository;
import com.api.spotify.service.CountryService;
import com.api.spotify.service.GenreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genre")
public class GenreRestController {

    private GenreService genreService;
    private GenreRepository genreRepository;

    public GenreRestController(GenreService genreService, GenreRepository genreRepository) {
        this.genreService = genreService;
        this.genreRepository = genreRepository;
    }

    @GetMapping
    public List<Genre> getList() {
        return genreService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Genre> getOne(@PathVariable Long id) {
        return genreService.getOne(id);
    }

    @PostMapping
    public ResponseEntity<Genre> createGenre(@RequestBody Genre newGenre) {
        return new ResponseEntity<>(genreService.save(newGenre), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genre> replaceGenre(@RequestBody Genre newGenre, @PathVariable Long id) {
        return new ResponseEntity<>(genreService.update(newGenre, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGenre(@PathVariable Long id) {
        genreService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
