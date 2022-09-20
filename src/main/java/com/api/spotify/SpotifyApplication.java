package com.api.spotify;

import com.api.spotify.repository.*;
import com.api.spotify.service.*;
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
	private UserTypeRepository userTypeRepository;
	private UserTypeService userTypeService;

	public SpotifyApplication(ArtistRepository artistRepository, ArtistService artistService, CountryRepository countryRepository, CountryService countryService, DiscographyRepository discographyRepository, DiscographyService discographyService, AlbumRepository albumRepository, AlbumService albumService, UserTypeRepository userTypeRepository, UserTypeService userTypeService) {
		this.artistRepository = artistRepository;
		this.artistService = artistService;
		this.countryRepository = countryRepository;
		this.countryService = countryService;
		this.discographyRepository = discographyRepository;
		this.discographyService = discographyService;
		this.albumRepository = albumRepository;
		this.albumService = albumService;
		this.userTypeRepository = userTypeRepository;
		this.userTypeService = userTypeService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpotifyApplication.class, args);
	}

}
