package com.server.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.server.models.entities.Movie;
import com.server.models.entities.MovieSearchDataAPI;
import com.server.models.request.MovieDataAPI;
import com.server.models.request.SearchResponseAPI;
import com.server.models.response.ResponseData;
import com.server.models.response.SearchResponseData;

@Service
public class APIHandler {

	private final static String API_KEY = "d138ddaf";

	private final static String OMDB_API_URL = "http://omdbapi.com/?apikey=" + API_KEY;

	private final static String NO_IMAGE = "https://media.comicbook.com/files/img/default-movie.png";
	
	private static Gson gson = new Gson();

	public SearchResponseData fetchMoviesByTitle(String title) {
		String searchUrl = OMDB_API_URL + "&s=" + title;
		String message = "movies fetched";
		boolean succeeded = false;
		MovieSearchDataAPI[] movies;

		try {
			String response = requestFromAPI(searchUrl);
			SearchResponseAPI movieSearchData = gson.fromJson(response, SearchResponseAPI.class);
			succeeded = Boolean.valueOf(movieSearchData.getResponse());

			if (succeeded) {
				movies = movieSearchData.getSearch();
				setDefaultImages(movies); // set default pictures for movies without an image
			} else {
				movies = new MovieSearchDataAPI[] {};
				message = movieSearchData.getError();
			}
		} catch (Exception ex) {
			movies = new MovieSearchDataAPI[] {};
			message = ex.getMessage();
		}

		return new SearchResponseData(movies, message, succeeded);
	}

	private void setDefaultImages(MovieSearchDataAPI[] search) {
		for (int i = 0; i < search.length; i++) {
			if (search[i].getPoster().equals("N/A")) {
				search[i].setPoster(NO_IMAGE);
			}
		}
	}
	
//	private MovieSearchDataAPI[] setDefaultImages(MovieSearchDataAPI[] search) {
//		for (int i = 0; i < search.length; i++) {
//			if (!search[i].getPoster().equals("N/A")) {
//				length++;
//			}
//		}
//
//		MovieSearchDataAPI[] newSearch = new MovieSearchDataAPI[length];
//
//		for (int i = 0; i < search.length; i++) {
//			if (!search[i].getPoster().equals("N/A")) {
//				newSearch[j++] = search[i];
//			}
//		}
//
//		return newSearch;
//	}

	public ResponseData fetchMovieById(String id) {
		Movie movie = getMovieById(id);
		ResponseData responseData = null;
		
		if (movie == null) {
			responseData = new ResponseData(null, "Movie not found", false);
		} else {
			responseData = new ResponseData(movie, id + " Found", true);
		}

		return responseData;
	}

	private Movie getMovieById(String id) {
		return getMovie("&i=" + id);
	}

	private Movie getMovie(String params) {
		String response = requestFromAPI(OMDB_API_URL + params);

		if (response.toLowerCase().contains("error")) {
			return null;
		} else {
			MovieDataAPI movieDataAPI = gson.fromJson(response, MovieDataAPI.class);
			return movieDataAPI.convertToClientSideMovie();
		}
	}

	@SuppressWarnings("finally")
	private String requestFromAPI(String requestedUrl) {
		URL url;
		HttpURLConnection connection = null;
		Reader streamReader = null;
		String respondeData = null;

		try {
			url = new URL(requestedUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);

			int status = connection.getResponseCode();

			if (status > 299) {
				streamReader = new InputStreamReader(connection.getErrorStream());
			} else {
				streamReader = new InputStreamReader(connection.getInputStream());
			}

			respondeData = getResponseData(streamReader);
		} catch (IOException e) {
			throw new IOException(e);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}

			return respondeData;
		}
	}

	private String getResponseData(Reader streamReader) throws IOException {
		StringBuffer content = new StringBuffer();
		BufferedReader inputStreamReader = new BufferedReader(streamReader);
		String inputLine;

		while ((inputLine = inputStreamReader.readLine()) != null) {
			content.append(inputLine);
		}

		inputStreamReader.close();

		return content.toString();
	}
}