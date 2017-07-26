package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.ArticlesApiService;
import com.example.demo.dto.Article;
import com.example.demo.dto.ArticlesSource;
import com.example.demo.respository.ArticleRepository;
import com.example.demo.respository.ArticlesSourceRepository;
import com.example.demo.services.ArticleService;

@RestController
public class ArticleRestController {

	@Autowired
	private ArticlesApiService apiService;
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private ArticlesSourceRepository articlesSourceRepository;
	@Autowired
	private ArticleService articleService;

	@RequestMapping("/getAllArticles")
	public Iterable<Article> getAllArticles() {
		return articleRepository.findAllByOrderByCreationDateDesc();
	}
	
	@RequestMapping("/getArticles4Source")
	public Iterable<Article> getArticles4Source(@RequestParam String source) {
		return articleRepository.findBySourceOrderByCreationDateDesc(source);
	}

	@RequestMapping("/getAllSources")
	public List<ArticlesSource> getAllSources() {
		List<ArticlesSource> result = apiService.getAllPossibleArticleSources();
		result.forEach(articleSoruce -> {
			if (articlesSourceRepository.findByIdenitifier(articleSoruce.getIdenitifier()).isEmpty()) {
				articlesSourceRepository.save(articleSoruce);
			}
		});
		return result;
	}

	@RequestMapping("/fetchArticlesForAllSources")
	public String fetchArticlesForAllSources() {
		articleService.fetchArticlesForAllSources();
		return "OK";
	}
}
