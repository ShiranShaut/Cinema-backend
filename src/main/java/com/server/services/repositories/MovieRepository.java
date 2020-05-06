package com.server.services.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.server.models.entities.MovieSearchDataAPI;

public interface MovieRepository extends JpaRepository<MovieSearchDataAPI, String> {

	@Query(value="SELECT * FROM movies WHERE title LIKE '%title%'", nativeQuery=true)
	List<MovieSearchDataAPI> getMoviesByLikeQuery(@Param("searchTerm") String title);
}