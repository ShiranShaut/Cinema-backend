package com.server.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.models.response.ResponseData;
import com.server.models.response.SearchResponseData;

@RestController
@RequestMapping("/cinema")
public class RequestHandlerController {
	
	@Autowired
	private DBHandler dbHandler;
	
	@Autowired
	private APIHandler apiHandler;

//	public RequestHandlerController() {
//		apiHandler = new APIHandler();
//		dbHandler = new DBHandler();
//	}

	@CrossOrigin
	@GetMapping("title/{title}")
	SearchResponseData searchByTitle(@PathVariable String title) {
		SearchResponseData searchResponseData = null;
		searchResponseData = dbHandler.fetchMovies(title);

		if (searchResponseData == null || !searchResponseData.isSucceded()) {
			searchResponseData = apiHandler.fetchMoviesByTitle(title);
			
			if (searchResponseData.isSucceded()) {
				dbHandler.saveMovies(searchResponseData.getMovies());
			}
		}

		return searchResponseData;
	}
 
	@CrossOrigin
	@GetMapping("id/{id}")
	ResponseData searchById(@PathVariable String id) {
		ResponseData responseData = null;
		responseData = dbHandler.getMovieById(id);

		if (responseData == null || !responseData.isSucceded()) {
			responseData = apiHandler.fetchMovieById(id);
			
			if (responseData.isSucceded()) {
				dbHandler.saveFullDetailMovie(responseData.getMovie());
			}
		}

		return responseData;
	}
}