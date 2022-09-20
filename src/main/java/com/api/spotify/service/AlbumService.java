package com.api.spotify.service;

import com.api.spotify.entity.Album;
import com.api.spotify.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    private AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> getAll() {
        return albumRepository.findAll();
    }

    public Optional<Album> getOne(Long id) {
        return albumRepository.findById(id);
    }

    public Album save(Album newAlbum) {
        return albumRepository.save(newAlbum);
    }

    public Album update(Album newAlbum, Long id) {
        return albumRepository.findById(id).map(
                album -> {
                    album.setTitle(newAlbum.getTitle());
                    album.setDiscography(newAlbum.getDiscography());
                    album.setArtist(newAlbum.getArtist());
                    album.setCoverImage(newAlbum.getCoverImage());
                    return album;
                }
        ).get();
    }

    public void delete(Long id) {
        albumRepository.deleteById(id);
    }

}
