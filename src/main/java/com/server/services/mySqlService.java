package com.server.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.models.entities.Movie;
import com.server.models.entities.MovieSearchDataAPI;
import com.server.services.repositories.MovieFullDataRepository;
import com.server.services.repositories.MovieRepository;
import com.server.services.repositories.SqlMovieQuery;

@Service
public class mySqlService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private SqlMovieQuery sqlMovieQuery;

	@Autowired
	private MovieFullDataRepository movieFullDataRepository;

	public MovieSearchDataAPI[] getMoviesByTitle(String title) {
		List<MovieSearchDataAPI> movieList = sqlMovieQuery.runLikeQuery(title);
//		List<MovieSearchDataAPI> movieList = movieRepository.getMoviesByLikeQuery(title);
		MovieSearchDataAPI[] movies = null;

		if (movieList.size() > 0) {
			movies = new MovieSearchDataAPI[movieList.size()];
			movieList.toArray(movies);
		}

		return movies;
	}
	
	public void saveMovies(MovieSearchDataAPI[] movies) {
		for (MovieSearchDataAPI movie : movies) {
			movieRepository.save(movie);
		}
	}
	
	public Movie getMovieById(String id) {
		Optional<Movie> movieData = movieFullDataRepository.findById(id);
		
		return (movieData.isEmpty()) ? null : movieData.get();
	}
	
	public void saveFullDetailMovie(Movie movie) {
		movieFullDataRepository.save(movie);
	}
}
