package com.pnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pnt.model.news.News;

public interface NewRepo extends JpaRepository<News, Long>{
	News findById(Long id);
}
