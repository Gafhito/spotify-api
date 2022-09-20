package com.api.spotify.repository;

import com.api.spotify.entity.PlaylistXSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistXSongRepository extends JpaRepository<PlaylistXSong, Long> {
}
