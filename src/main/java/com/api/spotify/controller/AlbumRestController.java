package com.api.spotify.controller;

import com.api.spotify.entity.Album;
import com.api.spotify.service.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/album")
public class AlbumRestController {

    private AlbumService albumService;

    public AlbumRestController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public List<Album> getList() {
        return albumService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Album> getAlbum(@PathVariable Long id) {
        return albumService.getOne(id);
    }

    @PostMapping
    public ResponseEntity<Album> createAlbum(@RequestBody Album newAlbum) {
        return new ResponseEntity<>(albumService.save(newAlbum), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Album> replaceAlbum(@RequestBody Album newAlbum, @PathVariable Long id) {
        return new ResponseEntity<>(albumService.update(newAlbum, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAlbum(@PathVariable Long id) {
        albumService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
