package com.api.spotify.controller;

import com.api.spotify.entity.Discography;
import com.api.spotify.repository.DiscographyRepository;
import com.api.spotify.service.DiscographyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/discography")
public class DiscographyRestController {

    private DiscographyService discographyService;
    private DiscographyRepository discographyRepository;

    public DiscographyRestController(DiscographyService discographyService, DiscographyRepository discographyRepository) {
        this.discographyService = discographyService;
        this.discographyRepository = discographyRepository;
    }

    @GetMapping
    public List<Discography> getList() {
        return discographyService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Discography> getOne(@PathVariable Long id) {
        return discographyService.getOne(id);
    }

    @PostMapping
    public ResponseEntity<Discography> createDiscography(@RequestBody Discography newDiscography) {
        return new ResponseEntity<>(discographyService.save(newDiscography), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Discography> replaceDiscography(@RequestBody Discography newDiscography, @PathVariable Long id) {
        return new ResponseEntity<>(discographyService.update(newDiscography, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDiscography(@PathVariable Long id) {
        discographyService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
