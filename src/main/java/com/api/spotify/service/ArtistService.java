package com.api.spotify.service;

import com.api.spotify.entity.Artist;
import com.api.spotify.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    private ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> getAll() {
        return artistRepository.findAll();
    }

    public Optional<Artist> getOne(Long id) {
        return artistRepository.findById(id);
    }

    public Artist save(Artist newArtist) {
        return artistRepository.save(newArtist);
    }

    public Artist update(Artist newArtist, Long id) {
        return artistRepository.findById(id).map(
                artist -> {
                    artist.setName(newArtist.getName());
                    artist.setImage(newArtist.getName());
                    return artist;
                }
        ).get();
    }

    public void delete(Long id) {
        artistRepository.deleteById(id);
    }

}
