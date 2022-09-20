package com.api.spotify.service;

import com.api.spotify.entity.Genre;
import com.api.spotify.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    private GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    public Optional<Genre> getOne(Long id) {
        return genreRepository.findById(id);
    }

    public Genre save(Genre newGenre) {
        return genreRepository.save(newGenre);
    }

    public Genre update(Genre newGenre, Long id) {
        return genreRepository.findById(id).map(
                genre -> {
                    genre.setGenre(newGenre.getGenre());
                    return genre;
                }
        ).get();
    }

    public void delete(Long id) {
        genreRepository.deleteById(id);
    }

}
