package com.api.spotify.service;

import com.api.spotify.entity.GenreXSong;
import com.api.spotify.repository.GenreXSongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreXSongService {

    private GenreXSongRepository genreXSongRepository;

    public GenreXSongService(GenreXSongRepository genreXSongRepository) {
        this.genreXSongRepository = genreXSongRepository;
    }

    public List<GenreXSong> getAll() {
        return genreXSongRepository.findAll();
    }

    public Optional<GenreXSong> getOne(Long id) {
        return genreXSongRepository.findById(id);
    }

    public GenreXSong save(GenreXSong newGenreXSong) {
        return genreXSongRepository.save(newGenreXSong);
    }

    public GenreXSong update(GenreXSong newGenreXSong, Long id) {
        return genreXSongRepository.findById(id).map(
                genreXSong -> {
                    genreXSong.setSong(newGenreXSong.getSong());
                    genreXSong.setGenre(newGenreXSong.getGenre());
                    return genreXSongRepository.save(genreXSong);
                }
        ).get();
    }

    public void delete(Long id) {
        genreXSongRepository.deleteById(id);
    }

}
