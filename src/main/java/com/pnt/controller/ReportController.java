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

import com.pnt.model.report.Report;
import com.pnt.service.ReportService;

@RestController
@RequestMapping("/report")
@CrossOrigin("*")
public class ReportController {
	@Autowired
	private ReportService reportService;
	
	//Thêm báo cáo
	@PostMapping("/")
	public ResponseEntity<?> addReport(@RequestBody Report report) {
		Report ReportData = this.reportService.addReport(report);
		return new ResponseEntity<>(ReportData, HttpStatus.CREATED);	
	}
	
	//Lấy thông tin tất cả báo cáo
	@GetMapping("/") 
	public ResponseEntity<?> getAllReport(){
		return ResponseEntity.ok(this.reportService.getAllReport());
	}
	
	//Lấy thông tin tất cả báo cáo theo userCode
	@GetMapping("/{userCode}") 
	public ResponseEntity<?> getReportByUserCode(@PathVariable("userCode") String userCode){
		return ResponseEntity.ok(this.reportService.getReportByUserCode(userCode));
	}
	
	// Cập nhật thông tin công ty
	@PutMapping("/")
	public ResponseEntity<Report> updateReport(@RequestBody Report report) {
		Report reportData = reportService.updateReport(report);
		return new ResponseEntity<>(reportData, HttpStatus.OK);
	}
	
	// Xóa thông tin công ty
	@DeleteMapping("/{id}") 
	public ResponseEntity<?> deleteReport(@PathVariable("id") Long id){
		reportService.deleteReport(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
