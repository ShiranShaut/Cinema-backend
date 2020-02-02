package com.server.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.models.entities.Movie;

public interface MovieFullDataRepository extends JpaRepository<Movie, String> {

}