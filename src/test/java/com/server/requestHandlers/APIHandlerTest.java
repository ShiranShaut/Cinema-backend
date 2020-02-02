package com.server.requestHandlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import com.server.handlers.APIHandler;
import com.server.models.response.ResponseData;

@Component
public class APIHandlerTest {

	private APIHandler apiHandler = new APIHandler();
	
	@Test
	public void getMovieById() {
		// id not exist
		ResponseData response = apiHandler.fetchMovieById("1"); 
		
		assertEquals(response.getMovie(), null);
		assertEquals(response.getMessage(), "Movie not found");
		assertEquals(response.isSucceded(), false);
		
		// id exist
		response = apiHandler.fetchMovieById("tt0003167"); 
		
		assertNotNull(response.getMovie());
		assertEquals(response.getMovie().getId(), "tt0003167");
		assertEquals(response.getMessage(), "tt0003167 Found");
		assertEquals(response.isSucceded(), true);	
	}
}