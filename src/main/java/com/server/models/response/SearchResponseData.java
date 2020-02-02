package com.server.models.response;

import com.server.models.entities.MovieSearchDataAPI;

public class SearchResponseData extends Response {
	
	private MovieSearchDataAPI[] movies;
	
	public SearchResponseData(MovieSearchDataAPI[] movies, String message, boolean succeded) {
		super(message, succeded);
		this.movies = movies;
	}

	public MovieSearchDataAPI[] getMovies() {
		return movies;
	}
	
	public void setMovies(MovieSearchDataAPI[] movies) {
		this.movies = movies;
	}
}