package com.server.models.request;

import com.server.models.entities.MovieSearchDataAPI;

public class SearchResponseAPI {
	
	private MovieSearchDataAPI[] Search; 
	
	private String totalResults;
	
	private String Response;
	
	private String Error;
	
	public MovieSearchDataAPI[] getSearch() {
		return Search;
	}
	
	public void setSearch(MovieSearchDataAPI[] search) {
		Search = search;
	}
	
	public String getTotalResults() {
		return totalResults;
	}
	
	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}
	
	public String getResponse() {
		return Response;
	}
	
	public void setResponse(String response) {
		Response = response;
	}

	public String getError() {
		return Error;
	}

	public void setError(String error) {
		Error = error;
	}
}