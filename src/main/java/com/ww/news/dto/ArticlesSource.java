package com.ww.news.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticlesSource {

	@Id
	@GeneratedValue
	@JsonIgnore
	private long id;
	@JsonProperty(value="id")
	private String idenitifier;
	private String name;
	@Column(columnDefinition = "TEXT")
	private String description;
	private String language;
	private String country;
	@ElementCollection
	private List<String> sortBysAvailable;

	public ArticlesSource() {
		id = -1;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdenitifier() {
		return idenitifier;
	}

	public void setIdenitifier(String idenitifier) {
		this.idenitifier = idenitifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<String> getSortBysAvailable() {
		return sortBysAvailable;
	}

	public void setSortBysAvailable(List<String> sortBysAvailable) {
		this.sortBysAvailable = sortBysAvailable;
	}

}
