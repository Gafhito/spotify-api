package com.api.spotify.controller;

import com.api.spotify.entity.Artist;
import com.api.spotify.repository.ArtistRepository;
import com.api.spotify.service.ArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artist")
public class ArtistRestController {

    ArtistService artistService;
    ArtistRepository artistRepository;

    public ArtistRestController(ArtistService artistService, ArtistRepository artistRepository) {
        this.artistService = artistService;
        this.artistRepository = artistRepository;
    }

    @GetMapping
    public List<Artist> getList() {
        return artistService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Artist> getArtist(@PathVariable Long id) {
        return artistService.getOne(id);
    }

    @PostMapping
    public ResponseEntity<Artist> newArtist(@RequestBody Artist newArtist) {
        return new ResponseEntity<>(artistService.save(newArtist), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artist> replaceArtist(@RequestBody Artist newArtist, @PathVariable Long id) {
        return new ResponseEntity<>(artistService.update(newArtist, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteArtist(@PathVariable Long id) {
        artistService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
