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
		@PostMapping("/")
		public ResponseEntity<Job> addJob(@RequestBody Job job) {
			Job jobData = this.jobService.addJob(job);
			return ResponseEntity.ok(jobData);
		}
		
		//Lấy thông tin tất cả thông tin tuyển dụng
		@GetMapping("/all") 
		public ResponseEntity<?> getAllJob(){
			return  ResponseEntity.ok(this.jobService.getAllJob());
		}
		
		//Lấy thông tin tuyển dụng theo id
		@GetMapping("/{jid}")
		public ResponseEntity<?> getJobById(@PathVariable("jid") Long jid){
			return  ResponseEntity.ok(this.jobService.findById(jid));
		}
		
		// Cập nhật thông tin tuyển dụng
		@PutMapping("/")
		public  ResponseEntity<?> updateJob(@RequestBody Job job) {
			return ResponseEntity.ok(this.jobService.updateJob(job)) ;
		}
		
		// Xóa thông tin tuyển dụng
		@DeleteMapping("/{jid}") 
		public void deleteCompany(@PathVariable("jid") Long jobId){
			this.jobService.deleteJob(jobId);
		}
}
