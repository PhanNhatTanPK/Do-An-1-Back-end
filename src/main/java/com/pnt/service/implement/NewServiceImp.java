package com.pnt.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnt.model.news.News;
import com.pnt.repository.NewRepo;
import com.pnt.service.NewService;

@Service
public class NewServiceImp implements NewService {
	@Autowired
	private NewRepo newRepo;

	@Override
	public News addNew(News news) {
		// TODO Auto-generated method stub
		return this.newRepo.save(news);
	}

	@Override
	public News updateNew(News news) {
		// TODO Auto-generated method stub
		return this.newRepo.save(news);
	}

	@Override
	public News findById(Long id) {
		// TODO Auto-generated method stub
		return this.newRepo.findById(id);
	}

	@Override
	public List<News> getAllNew() {
		// TODO Auto-generated method stub
		return this.newRepo.findAll();
	}

	@Override
	public void deleteNew(Long id) {
		// TODO Auto-generated method stub
		this.newRepo.delete(id);
	}

}
