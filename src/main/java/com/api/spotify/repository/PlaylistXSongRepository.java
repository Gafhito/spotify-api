package com.api.spotify.repository;

import com.api.spotify.entity.PlaylistXSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaylistXSongRepository extends JpaRepository<PlaylistXSong, Long> {

    // Este Repository NO funciona (?

    @Query(value = "select pxs.id, pxs.song, pxs.playlist from playlist_x_song pxs", nativeQuery = true)
    List<PlaylistXSong> findAll();

    @Query(value = "select pxs.id, pxs.song, pxs.playlist from playlist_x_song pxs where pxs.id = ?1", nativeQuery = true)
    Optional<PlaylistXSong> findById(Long id);

}
