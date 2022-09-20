package com.api.spotify.service;

import com.api.spotify.entity.Song;
import com.api.spotify.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getAll() {
        return songRepository.findAll();
    }

    public Optional<Song> getOne(Long id) {
        return songRepository.findById(id);
    }

    public Song save(Song newSong) {
        return songRepository.save(newSong);
    }

    public Song update(Song newSong, Long id) {
        return songRepository.findById(id).map(
                song -> {
                    song.setTitle(newSong.getTitle());
                    song.setDuration(newSong.getDuration());
                    song.setPlaybackAmount(newSong.getPlaybackAmount());
                    song.setLikes(newSong.getLikes());
                    song.setAlbum(newSong.getAlbum());
                    return song;
                }
        ).get();
    }

    public void delete(Long id) {
        songRepository.deleteById(id);
    }

}
