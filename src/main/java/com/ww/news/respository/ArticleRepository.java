package com.ww.news.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ww.news.dto.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {
	
	public List<Article> findByAuthorAndTitle(String author, String title);
	
	public List<Article> findBySourceOrderByCreationDateDesc(String source);
	
	public List<Article> findAllByOrderByCreationDateDesc();
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Article save(Article entity);

}
