package com.pnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.pnt.model.company.Job;
import com.pnt.service.JobService;

@RestController
@RequestMapping("/job")
@CrossOrigin("*")
public class JobController {
	@Autowired
	private JobService jobService;
	
	//Thêm công ty
		@PostMapping("/create")
		public ResponseEntity<?> addJob(@RequestBody Job job) {
			Job jobData = this.jobService.addJob(job);
			return ResponseEntity.ok(jobData);
		}
		
		// Lấy thông tin công ty từ id
		@GetMapping("/{jobId}")
		public Job getJob(@PathVariable("jobId") Long jobId) {
			return this.jobService.getJob(jobId);
		}
		
		//Lấy thông tin tất cả công ty
		@GetMapping("/all") 
		public ResponseEntity<?> getAllJob(){
			return  ResponseEntity.ok(this.jobService.getAllJob());
		}
		
		
		// Cập nhật thông tin công ty
		@PutMapping("/update")
		public  ResponseEntity<?> updateJob(@RequestBody Job job) {
			return ResponseEntity.ok(this.jobService.updateJob(job)) ;
		}
		
		// Xóa thông tin công ty
		@DeleteMapping("/{jobId}") 
		public void deleteCompany(@PathVariable("jobId") Long jobId){
			this.jobService.deleteJob(jobId);
		}
}
