package com.ww.news.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ww.news.dto.ArticlesSource;

public interface ArticlesSourceRepository extends CrudRepository<ArticlesSource, Long> {
	
	public List<ArticlesSource> findByIdenitifier(String identifier);
}
