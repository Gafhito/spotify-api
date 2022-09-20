package com.api.spotify.service;

import com.api.spotify.entity.Discography;
import com.api.spotify.repository.DiscographyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscographyService {

    private DiscographyRepository discographyRepository;

    public DiscographyService(DiscographyRepository discographyRepository) {
        this.discographyRepository = discographyRepository;
    }

    public List<Discography> getAll() {
        return discographyRepository.findAll();
    }

    public Optional<Discography> getOne(Long id) {
        return discographyRepository.findById(id);
    }

    public Discography save(Discography newDiscography) {
        return discographyRepository.save(newDiscography);
    }

    public Discography update(Discography newDiscography, Long id) {
        return discographyRepository.findById(id).map(
                discography -> {
                    discography.setName(newDiscography.getName());
                    discography.setCountry(newDiscography.getCountry());
                    return discography;
                }
        ).get();
    }

    public void delete(Long id) {
        discographyRepository.deleteById(id);
    }

}
