package com.server.models.response;

import com.server.models.entities.Movie;

public class ResponseData extends Response {
	
	private Movie movie;
	
	public ResponseData(Movie movie, String message, boolean succeded) {
		super(message, succeded);
		this.movie = movie;
	}

	public Movie getMovie() {
		return movie;
	}
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
}