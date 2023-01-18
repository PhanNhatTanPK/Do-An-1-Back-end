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

import com.pnt.model.company.Company;
import com.pnt.service.CompanyService;

@RestController
@RequestMapping("/company")
@CrossOrigin("*")
public class CompanyController {
	@Autowired
	private  CompanyService companyService;
	
	//Thêm công ty
	@PostMapping("/")
	public ResponseEntity<?> addCompany(@RequestBody Company company) {
		Company companyData = this.companyService.addCompany(company);
		return new ResponseEntity<>(companyData, HttpStatus.CREATED);	
	}
	
	// Lấy thông tin công ty từ id
	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompany(@PathVariable("id") Long id) {
		Company company = companyService.findCompanyById(id);
		return new ResponseEntity<>(company, HttpStatus.OK);
	}
	
	//Lấy thông tin tất cả công ty
	@GetMapping("/all") 
	public ResponseEntity<?> getAllCompany(){
		return ResponseEntity.ok(this.companyService.getAllCompany());
	}
	
	// Cập nhật thông tin công ty
	@PutMapping("/")
	public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
		Company companyData = companyService.updateCompany(company);
		return new ResponseEntity<>(companyData, HttpStatus.OK);
	}
	
	// Xóa thông tin công ty
	@DeleteMapping("/{id}") 
	public ResponseEntity<?> deleteCompany(@PathVariable("id") Long id){
		companyService.deleteCompany(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
