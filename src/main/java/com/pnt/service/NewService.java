package com.pnt.service;

import java.util.List;

import com.pnt.model.news.News;


public interface NewService {
	public News addNew(News news);
	public News updateNew(News news);
	public News findById(Long id);
	public List<News> getAllNew();
	public void deleteNew(Long id);
}
