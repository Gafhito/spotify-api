package com.api.spotify.repository;

import com.api.spotify.entity.GenreXSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreXSongRepository extends JpaRepository<GenreXSong, Long> {

    // Este Repository funciona ok...

    @Query(value = "select gxs.id, gxs.genre, gxs.song from genre_x_song as gxs", nativeQuery = true)
    List<GenreXSong> findAll();

    @Query(value = "select gxs.id, gxs.genre, gxs.song from genre_x_song as gxs where gxs.id = ?1", nativeQuery = true)
    Optional<GenreXSong> findById(Long id);

}
