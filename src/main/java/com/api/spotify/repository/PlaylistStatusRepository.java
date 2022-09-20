package com.api.spotify.repository;

import com.api.spotify.entity.PlaylistStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistStatusRepository extends JpaRepository<PlaylistStatus, Long> {
}
