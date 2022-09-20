package com.api.spotify;

import com.api.spotify.repository.AlbumRepository;
import com.api.spotify.repository.ArtistRepository;
import com.api.spotify.repository.CountryRepository;
import com.api.spotify.repository.DiscographyRepository;
import com.api.spotify.service.AlbumService;
import com.api.spotify.service.ArtistService;
import com.api.spotify.service.CountryService;
import com.api.spotify.service.DiscographyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpotifyApplication {

	private ArtistRepository artistRepository;
	private ArtistService artistService;
	private CountryRepository countryRepository;
	private CountryService countryService;
	private DiscographyRepository discographyRepository;
	private DiscographyService discographyService;
	private AlbumRepository albumRepository;
	private AlbumService albumService;

	public SpotifyApplication(ArtistRepository artistRepository, ArtistService artistService, CountryRepository countryRepository, CountryService countryService, DiscographyRepository discographyRepository, DiscographyService discographyService, AlbumRepository albumRepository, AlbumService albumService) {
		this.artistRepository = artistRepository;
		this.artistService = artistService;
		this.countryRepository = countryRepository;
		this.countryService = countryService;
		this.discographyRepository = discographyRepository;
		this.discographyService = discographyService;
		this.albumRepository = albumRepository;
		this.albumService = albumService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpotifyApplication.class, args);
	}

}
