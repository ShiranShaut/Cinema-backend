package com.server.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.models.entities.Movie;
import com.server.models.entities.MovieSearchDataAPI;
import com.server.models.response.ResponseData;
import com.server.models.response.SearchResponseData;
import com.server.services.mySqlService;

@Service
public class DBHandler {

	@Autowired
	private mySqlService sqlService;

	public SearchResponseData fetchMovies(String title) {
		SearchResponseData responseData = null;
		MovieSearchDataAPI[] movies = sqlService.getMoviesByTitle(title);
		
		if(movies != null) {
			responseData = new SearchResponseData(movies, "total results: " + movies.length, true);
		} else {
			responseData = new SearchResponseData(new MovieSearchDataAPI[] {}, "Movies Not Found In DB!", false);
		}

		return responseData;
	}

	public void saveMovies(MovieSearchDataAPI[] movies) {
		sqlService.saveMovies(movies);
	}

	public ResponseData getMovieById(String id) {
		Movie movie = sqlService.getMovieById(id);
		ResponseData responseData = null;

		if (movie == null) {
			responseData = new ResponseData(null, "Movie not exist in Database", false);
		} else {
			responseData = new ResponseData(movie, id + " Found", true);
		}

		return responseData;
	}

	public void saveFullDetailMovie(Movie movie) {
		sqlService.saveFullDetailMovie(movie);
	}
}