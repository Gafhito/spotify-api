package com.api.spotify.service;

import com.api.spotify.entity.Country;
import com.api.spotify.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    public Optional<Country> getOne(Long id) {
        return countryRepository.findById(id);
    }

    public Country save(Country newCountry) {
        return countryRepository.save(newCountry);
    }

    public Country update(Country newCountry, Long id) {
        return countryRepository.findById(id).map(
                country -> {
                    country.setCountry(newCountry.getCountry());
                    return countryRepository.save(country);
                }
        ).get();
    }

    public void delete(Long id) {
        countryRepository.deleteById(id);
    }

}
