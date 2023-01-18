package com.pnt.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pnt.model.dto.CompanyDto;
import com.pnt.model.dto.ResultDto;
import com.pnt.model.dto.UserDto;
import com.pnt.model.user.User;
import com.pnt.service.CompanyService;
import com.pnt.service.ResultService;
import com.pnt.service.UserService;
import com.pnt.service.implement.StatisticServiceImp;

@RestController
@RequestMapping("/statistic")
@CrossOrigin("*")
public class StatisticController {
	@Autowired
	private StatisticServiceImp statisticService;
	@Autowired
	private UserService userService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private ResultService resultService;

	// Xuất file Excel thông tin giảng viên
	@GetMapping("/teacher/export")
	public ResponseEntity<InputStreamResource> exportTeacher() throws IOException{
			List<User> list = (List<User>) userService.getAllTeacher();
			
			ByteArrayInputStream in = statisticService.teacherToExcel(list);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment; filename=Teacher.xlsx");
			return ResponseEntity
					.ok()
					.headers(headers)
					.body(new InputStreamResource(in));		
	}
	
	// Xuất file Excel thông tin sinh viên
	@GetMapping("/student/export")
	public ResponseEntity<InputStreamResource> exportStudent() throws IOException{
			List<UserDto> list = (List<UserDto>) userService.getStudentExport();
			
			ByteArrayInputStream in = statisticService.studentToExcel(list);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment; filename=Student.xlsx");
			return ResponseEntity
					.ok()
					.headers(headers)
					.body(new InputStreamResource(in));		
	}
	
	// Xuất file Excel thông tin công ty
	@GetMapping("/company/export")
	public ResponseEntity<InputStreamResource> exportCompany() throws IOException{
			List<CompanyDto> list = companyService.getCompanyExport();
			
			ByteArrayInputStream in = statisticService.companyToExcel(list);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment; filename=Company.xlsx");
			return ResponseEntity
					.ok()
					.headers(headers)
					.body(new InputStreamResource(in));		
	}
	
	// Xuất file Excel thông tin kết quả thực tập
	@GetMapping("/result/export")
	public ResponseEntity<InputStreamResource> exportResult() throws IOException{
			List<ResultDto> list = resultService.getTotalPointExport();
			
			ByteArrayInputStream in = statisticService.resultToExcel(list);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment; filename=Result.xlsx");
			return ResponseEntity
					.ok()
					.headers(headers)
					.body(new InputStreamResource(in));		
	}
	
	// Xuất file Excel thông tin kết quả thực tập
		@GetMapping("/intern/export")
		public ResponseEntity<InputStreamResource> exportIntern() throws IOException{
				List<UserDto> list = userService.getStudentExport();
				
				ByteArrayInputStream in = statisticService.internToExcel(list);
				
				HttpHeaders headers = new HttpHeaders();
				headers.add("Content-Disposition", "attachment; filename=Intern.xlsx");
				return ResponseEntity
						.ok()
						.headers(headers)
						.body(new InputStreamResource(in));		
		}
	
	@GetMapping("/teacher/")
	public ResponseEntity<?> getNumberTeacher() {
		return ResponseEntity.ok(this.statisticService.getNumberTeacher());	
	}
		
	@GetMapping("/student/")
	public ResponseEntity<?> getNumberStudent() {
		return ResponseEntity.ok(this.statisticService.getNumberStudent());	
	}
	
	@GetMapping("/company/")
	public ResponseEntity<?> getNumberCompany() {
		return ResponseEntity.ok(this.statisticService.getNumberCompany());	
	}
}
