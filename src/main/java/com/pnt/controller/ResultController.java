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

import com.pnt.model.result.Result;
import com.pnt.service.ResultService;

@RestController
@RequestMapping("/result")
@CrossOrigin("*")
public class ResultController {
	@Autowired
	private ResultService resultService;
	
	//Thêm công ty
	@PostMapping("/")
	public ResponseEntity<?> addResult(@RequestBody Result result) {
		Double total = 0.0;
		total = (result.getLecturePoint() + result.getInstructorPoint())/2;
		result.setTotalPoint(total);
		Result resultData = this.resultService.addResult(result);
		return new ResponseEntity<>(resultData, HttpStatus.CREATED);	
	}
	
	//Lấy thông tin tất cả công ty
	@GetMapping("/") 
	public ResponseEntity<?> getAllResult(){
		return ResponseEntity.ok(this.resultService.getAllResult());
	}
	
	// Cập nhật thông tin công ty
	@PutMapping("/")
	public ResponseEntity<Result> updateResult(@RequestBody Result result) {
		Double total = 0.0;
		total = (result.getLecturePoint() + result.getInstructorPoint())/2;
		result.setTotalPoint(total);
		Result resultData = resultService.updateResult(result);
		return new ResponseEntity<>(resultData, HttpStatus.OK);
	}
	
	// Xóa thông tin công ty
	@DeleteMapping("/{id}") 
	public ResponseEntity<?> deleteResult(@PathVariable("id") Long id){
		resultService.deleteResult(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
