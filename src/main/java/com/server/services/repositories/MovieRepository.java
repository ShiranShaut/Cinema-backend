package com.server.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.models.entities.MovieSearchDataAPI;

public interface MovieRepository extends JpaRepository<MovieSearchDataAPI, String> {

}