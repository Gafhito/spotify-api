package com.api.spotify;

import com.api.spotify.repository.ArtistRepository;
import com.api.spotify.service.ArtistService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpotifyApplication {

	ArtistRepository artistRepository;
	ArtistService artistService;

	public SpotifyApplication(ArtistRepository artistRepository, ArtistService artistService) {
		this.artistRepository = artistRepository;
		this.artistService = artistService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpotifyApplication.class, args);
	}

}
