package com.api.spotify.repository;

import com.api.spotify.entity.PlaylistXSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaylistXSongRepository extends JpaRepository<PlaylistXSong, Long> {

    @Query(value = "select pxs.id, pxs.playlist, pxs.song from playlist_x_song as pxs", nativeQuery = true)
    List<PlaylistXSong> findAll();

    @Query(value = "select pxs.id, pxs.playlist, pxs.song from playlist_x_song as pxs where pxs.id = ?1", nativeQuery = true)
    Optional<PlaylistXSong> findById(Long id);

}
