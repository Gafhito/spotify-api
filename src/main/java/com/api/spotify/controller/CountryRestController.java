package com.api.spotify.controller;

import com.api.spotify.entity.Country;
import com.api.spotify.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/country")
public class CountryRestController {

    private CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getList() {
        return countryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Country> getCountry(@PathVariable Long id) {
        return countryService.getOne(id);
    }

    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody Country newCountry) {
        return new ResponseEntity<>(countryService.save(newCountry), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> replaceCountry(@RequestBody Country newCountry, @PathVariable Long id) {
        return new ResponseEntity<>(countryService.update(newCountry, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCountry(@PathVariable Long id) {
        countryService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
