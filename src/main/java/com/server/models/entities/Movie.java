package com.server.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.server.models.Rating;

@Entity
@Table(name = "MoviesFullData")
public class Movie {
	@Id
	private String id;

	@Column(name = "title")
	private String title;

	@Column(name = "year")
	private String year;

	@Column(name = "type")
	private String type;

	@Column(name = "imgSrc")
	private String imgSrc;

	@Column(name = "released")
	private String released;

	@Column(name = "runtime")
	private String runtime;

	@Column(name = "genre")
	private String genre;

	@Column(name = "director")
	private String director;

	@Column(name = "writer")
	private String writer;

	@Column(name = "actors")
	private String actors;

	@Column(name = "plot")
	private String plot;

	@Column(name = "language")
	private String language;

	@Column(name = "country")
	private String country;

	@Column(name = "awards")
	private String awards;

	@Column(name = "imdbRating")
	private String imdbRating;

	@Column(name = "imdbVotes")
	private String imdbVotes;

	@Column(name = "production")
	private String production;

	@Column(name = "website")
	private String website;

	@Column(name = "ratings")
	private Rating[] ratings;

	public Movie() {
	}

	public Movie(String id, String title, String year, String type, String imgSrc, String released, String runtime,
			String genre, String director, String writer, String actors, String plot, String language, String country,
			String awards, String imdbRating, String imdbVotes, String production, String website, Rating[] ratings) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.type = type;
		this.imgSrc = imgSrc;
		this.released = released;
		this.runtime = runtime;
		this.genre = genre;
		this.director = director;
		this.writer = writer;
		this.actors = actors;
		this.plot = plot;
		this.language = language;
		this.country = country;
		this.awards = awards;
		this.imdbRating = imdbRating;
		this.imdbVotes = imdbVotes;
		this.production = production;
		this.website = website;
		this.ratings = ratings;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}

	public String getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Rating[] getRatings() {
		return ratings;
	}

	public void setRatings(Rating[] ratings) {
		this.ratings = ratings;
	}
}