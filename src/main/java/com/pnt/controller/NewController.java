package com.pnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pnt.model.news.News;
import com.pnt.service.NewService;

@RestController
@RequestMapping("/new")
@CrossOrigin("*")
public class NewController {
	@Autowired
	private NewService newService;
	
	@PostMapping("/")
	public ResponseEntity<?> addNew(@RequestBody News news) {
		news.setImage("https://th.bing.com/th/id/R.e62401e75b637eaa400253bc786cb88e?rik=%2beyVZYY7S5n7ZQ&riu=http%3a%2f%2famericodirect.net%2fwp-content%2fuploads%2f2016%2f01%2fLoud-Speaker.png&ehk=0ZdIc%2bG8x21%2bgzsx%2fXDjagP3f8L38plZNJNKbss1luQ%3d&risl=&pid=ImgRaw&r=0");
		News newData = this.newService.addNew(news);
		return new ResponseEntity<>(newData, HttpStatus.CREATED);	
	}
	
	// Lấy thông tin tin tức từ id
	@GetMapping("/{id}")
	public ResponseEntity<News> getNew(@PathVariable("id") Long id) {
		News newData = this.newService.findById(id);
		return new ResponseEntity<>(newData, HttpStatus.OK);
	}
	
	//Lấy thông tin tất cả tin tức
	@GetMapping("/all") 
	public ResponseEntity<?> getAllCompany(){
		return ResponseEntity.ok(this.newService.getAllNew());
	}
	
	// Cập nhật thông tin tin tức
	@PutMapping("/")
	public ResponseEntity<News> updateNew(@RequestBody News news) {
		News newData = this.newService.updateNew(news);
		return new ResponseEntity<>(newData, HttpStatus.OK);
	}
	
	// Xóa tin tức
	@DeleteMapping("/{id}") 
	public ResponseEntity<?> deleteNew(@PathVariable("id") Long id){
		this.newService.deleteNew(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
