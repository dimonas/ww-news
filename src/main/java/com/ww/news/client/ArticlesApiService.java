package com.ww.news.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ww.news.dto.Article;
import com.ww.news.dto.ArticleResponse;
import com.ww.news.dto.ArticlesSource;
import com.ww.news.dto.ArticlesSourceResponse;

//c815948baeb649679d89ea02b13832a2

// https://newsapi.org/v1/articles?source=bbc-sport&sortBy=top&apiKey={api-key}
@Component
public class ArticlesApiService {
	
	
	public List<Article> getArticlesFromApi() {
		RestTemplate restTemplate = new RestTemplate();
		ArticleResponse articleResponse = restTemplate.getForObject("https://newsapi.org/v1/articles?source=bbc-sport&sortBy=top&apiKey={api-key}", ArticleResponse.class, "c815948baeb649679d89ea02b13832a2");
		return articleResponse.getArticles();
	}
	
	public List<ArticlesSource> getAllPossibleArticleSources() {
		RestTemplate restTemplate = new RestTemplate();
		ArticlesSourceResponse articleResponse = restTemplate.getForObject("https://newsapi.org/v1/sources", ArticlesSourceResponse.class);
		return articleResponse.getSources();
	}
	
	public List<Article> getArticlesFromApi4Source(String sourceId, String sortBy) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			ArticleResponse articleResponse = restTemplate.getForObject("https://newsapi.org/v1/articles?source={source}&sortBy={sortedBy}&apiKey={api-key}", ArticleResponse.class, sourceId, sortBy, "c815948baeb649679d89ea02b13832a2");
			return articleResponse.getArticles();
		} catch (Throwable e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
}
