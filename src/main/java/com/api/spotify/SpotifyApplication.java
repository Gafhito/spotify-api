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
	private UserRepository userRepository;
	private UserService userService;
	private GenreRepository genreRepository;
	private GenreService genreService;
	private SongRepository songRepository;
	private SongService songService;
	private GenreXSongRepository genreXSongRepository;
	private GenreXSongService genreXSongService;
	private PlaylistStatusRepository playlistStatusRepository;
	private PlaylistStatusService playlistStatusService;
	private PlaylistRepository playlistRepository;
	private PlaylistService playlistService;

	public SpotifyApplication(ArtistRepository artistRepository, ArtistService artistService, CountryRepository countryRepository, CountryService countryService, DiscographyRepository discographyRepository, DiscographyService discographyService, AlbumRepository albumRepository, AlbumService albumService, UserTypeRepository userTypeRepository, UserTypeService userTypeService, UserRepository userRepository, UserService userService, GenreRepository genreRepository, GenreService genreService, SongRepository songRepository, SongService songService, GenreXSongRepository genreXSongRepository, GenreXSongService genreXSongService, PlaylistStatusRepository playlistStatusRepository, PlaylistStatusService playlistStatusService, PlaylistRepository playlistRepository, PlaylistService playlistService) {
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
		this.userRepository = userRepository;
		this.userService = userService;
		this.genreRepository = genreRepository;
		this.genreService = genreService;
		this.songRepository = songRepository;
		this.songService = songService;
		this.genreXSongRepository = genreXSongRepository;
		this.genreXSongService = genreXSongService;
		this.playlistStatusRepository = playlistStatusRepository;
		this.playlistStatusService = playlistStatusService;
		this.playlistRepository = playlistRepository;
		this.playlistService = playlistService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpotifyApplication.class, args);
	}

}
