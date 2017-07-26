package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticlesSourceResponse {

	private List<ArticlesSource> sources;

	public List<ArticlesSource> getSources() {
		return sources;
	}

	public void setSources(List<ArticlesSource> sources) {
		this.sources = sources;
	}

}
