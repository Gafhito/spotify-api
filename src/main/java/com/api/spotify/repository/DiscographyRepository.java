package com.api.spotify.repository;

import com.api.spotify.entity.Discography;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscographyRepository extends JpaRepository<Discography, Long> {
}
