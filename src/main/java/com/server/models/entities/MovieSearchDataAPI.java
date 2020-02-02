package com.server.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Movies")
public class MovieSearchDataAPI {
	
	@Id
	private String imdbID;
	
	@Column(name = "title")
	private String Title;
	
	@Column(name = "year")
	private String Year;
	
	@Column(name = "type")
	private String Type;
	
	@Column(name = "imgSrc")
	private String Poster;

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getPoster() {
		return Poster;
	}

	public void setPoster(String poster) {
		Poster = poster;
	}
}