package com.server.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.models.response.ResponseData;
import com.server.models.response.SearchResponseData;
import com.server.services.SqlQueryService;
import com.server.services.repositories.MovieFullDataRepository;
import com.server.services.repositories.MovieRepository;

@RestController
@RequestMapping("/cinema")
public class RequestHandlerController {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private MovieFullDataRepository movieFullDataRepository;

	@Autowired
	private SqlQueryService sqlQueryService;

	private APIHandler apiHandler;

	public RequestHandlerController() {
		apiHandler = new APIHandler();
	}

	@CrossOrigin
	@GetMapping("title/{title}")
	SearchResponseData searchByTitle(@PathVariable String title) {
		SearchResponseData searchResponseData = null;
		DatabaseHandler databaseHandler = new DatabaseHandler(movieRepository, sqlQueryService,
				movieFullDataRepository);
		searchResponseData = databaseHandler.fetchMovies(title);

		if (searchResponseData == null || !searchResponseData.isSucceded()) {
			searchResponseData = apiHandler.fetchMovies(title);
			if (searchResponseData.isSucceded()) {
				databaseHandler.saveMovies(searchResponseData.getMovies());
			}
		}

		return searchResponseData;
	}
 
	@CrossOrigin
	@GetMapping("id/{id}")
	ResponseData searchById(@PathVariable String id) {
		ResponseData responseData = null;
		DatabaseHandler databaseHandler = new DatabaseHandler(movieRepository, sqlQueryService,
				movieFullDataRepository);
		responseData = databaseHandler.getMovieById(id);

		if (responseData == null || !responseData.isSucceded()) {
			responseData = apiHandler.fetchMovieById(id);
			if (responseData.isSucceded()) {
				databaseHandler.saveFullDetailMovie(responseData.getMovie());
			}
		}

		return responseData;
	}
}