package com.server.handlers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.server.models.entities.Movie;
import com.server.models.entities.MovieSearchDataAPI;
import com.server.models.response.ResponseData;
import com.server.models.response.SearchResponseData;
import com.server.services.SqlQueryService;
import com.server.services.repositories.MovieFullDataRepository;
import com.server.services.repositories.MovieRepository;

@Service
public class DatabaseHandler {

	private MovieRepository movieRepository;

	private SqlQueryService sqlQueryService;

	private MovieFullDataRepository movieFullDataRepository;

	public DatabaseHandler(MovieRepository movieRepository, SqlQueryService sqlQueryService,
			MovieFullDataRepository movieFullDataRepository) {
		this.movieRepository = movieRepository;
		this.sqlQueryService = sqlQueryService;
		this.movieFullDataRepository = movieFullDataRepository;
	}

	public SearchResponseData fetchMovies(String title) {
		SearchResponseData responseData = null;
		List<MovieSearchDataAPI> movieList = sqlQueryService.runLikeQuery(title);

		if (movieList.size() > 0) {
			MovieSearchDataAPI[] movies = new MovieSearchDataAPI[movieList.size()];
			int i = 0;

			for (MovieSearchDataAPI movie : movieList) {
				movies[i++] = movie;
			}

			responseData = new SearchResponseData(movies, "total results: " + movieList.size(), true);
		} else {
			responseData = new SearchResponseData(new MovieSearchDataAPI[] {}, "Movie Not Found In DB!", false);
		}

		return responseData;
	}

	public void saveMovies(MovieSearchDataAPI[] movies) {
		for (MovieSearchDataAPI movie : movies) {
			movieRepository.save(movie);
		}
	}

	public ResponseData getMovieById(String id) {
		Optional<Movie> movieData = movieFullDataRepository.findById(id);
		Movie movie = (movieData.isEmpty()) ? null : movieData.get();
		ResponseData responseData = null;

		if (movie == null) {
			responseData = new ResponseData(null, "Movie not exist in Database", false);
		} else {
			responseData = new ResponseData(movie, id + " Found", true);
		}

		return responseData;
	}

	public void saveFullDetailMovie(Movie movie) {
		movieFullDataRepository.save(movie);
	}
}