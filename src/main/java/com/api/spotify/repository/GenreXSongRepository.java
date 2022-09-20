package com.api.spotify.repository;

import com.api.spotify.entity.GenreXSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreXSongRepository extends JpaRepository<GenreXSong, Long> {
}
