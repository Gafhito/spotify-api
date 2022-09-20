package com.api.spotify;

import com.api.spotify.repository.ArtistRepository;
import com.api.spotify.repository.CountryRepository;
import com.api.spotify.service.ArtistService;
import com.api.spotify.service.CountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpotifyApplication {

	ArtistRepository artistRepository;
	ArtistService artistService;
	CountryRepository countryRepository;
	CountryService countryService;

	public SpotifyApplication(ArtistRepository artistRepository, ArtistService artistService, CountryRepository countryRepository, CountryService countryService) {
		this.artistRepository = artistRepository;
		this.artistService = artistService;
		this.countryRepository = countryRepository;
		this.countryService = countryService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpotifyApplication.class, args);
	}

}
