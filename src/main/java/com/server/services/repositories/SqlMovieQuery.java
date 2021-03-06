package com.server.services.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.server.models.entities.MovieSearchDataAPI;

@Repository
public class SqlMovieQuery {

	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public List<MovieSearchDataAPI> runLikeQuery(String title) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MovieSearchDataAPI> criteria = criteriaBuilder.createQuery(MovieSearchDataAPI.class);
		Root<MovieSearchDataAPI> root = criteria.from(MovieSearchDataAPI.class);
		String pattern = "%" + title + "%";

		// returned data will be of type Movie
		criteria.select(root);
		criteria.where(criteriaBuilder.like(root.get("Title"), pattern));
		
		// query - SELECT * FROM movies where title LIKE %title%
		Query query = entityManager.createQuery(criteria);
		List<MovieSearchDataAPI> movieList = query.getResultList();
		
		return movieList;
	}
}