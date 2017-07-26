package com.example.demo.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.dto.ArticlesSource;

public interface ArticlesSourceRepository extends CrudRepository<ArticlesSource, Long> {
	
	public List<ArticlesSource> findByIdenitifier(String identifier);
}
