package com.ww.news.services;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ww.news.client.ArticlesApiService;
import com.ww.news.dto.Article;
import com.ww.news.dto.ArticlesSource;
import com.ww.news.respository.ArticleRepository;
import com.ww.news.respository.ArticlesSourceRepository;

@Service
public class ArticleService {

	@Autowired
	private ArticlesApiService apiService;
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private ArticlesSourceRepository articlesSourceRepository;

	@Transactional
	public boolean saveArticlesIfDoesntExists(Iterable<Article> articles, Consumer<Article> articleConsumer) {
		try {
			for (Article article : articles) {
				if (articleRepository.findByAuthorAndTitle(article.getAuthor(), article.getTitle()).isEmpty()) {
					if (articleConsumer != null) {		
						articleConsumer.accept(article);
					}
					System.out.println("Save artice: " + article.getDescription());
					if (!"Martha Tesema".equals(article.getAuthor())) {
						articleRepository.save(article);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
	public void fetchArticlesForAllSources() {
		Iterable<ArticlesSource> allSources = articlesSourceRepository.findAll();
		allSources.forEach(articleSource -> {
			System.out.println("Porcess source: " + articleSource.getName());
			List<String> sortBysAvailable = articleSource.getSortBysAvailable();
			if (!sortBysAvailable.isEmpty()) {
				List<Article> result = apiService.getArticlesFromApi4Source(articleSource.getIdenitifier(), sortBysAvailable.iterator().next());
				saveArticlesIfDoesntExists(result, article -> article.setSource(articleSource.getIdenitifier()));
			}
		});
	}
	 @Scheduled(fixedDelay=1200000)
	 @Transactional
	public void fetchArticlesSheduled() {
		 System.out.println("Fetch Articles....");
		 fetchArticlesForAllSources();
	}
}
