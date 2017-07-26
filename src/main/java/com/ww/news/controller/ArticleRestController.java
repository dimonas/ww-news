package com.ww.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ww.news.client.ArticlesApiService;
import com.ww.news.dto.Article;
import com.ww.news.dto.ArticlesSource;
import com.ww.news.respository.ArticleRepository;
import com.ww.news.respository.ArticlesSourceRepository;
import com.ww.news.services.ArticleService;

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
