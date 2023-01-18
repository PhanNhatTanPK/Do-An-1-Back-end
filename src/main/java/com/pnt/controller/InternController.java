package com.pnt.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pnt.model.intern.Intern;
import com.pnt.model.user.Role;
import com.pnt.model.user.User;
import com.pnt.model.user.UserRole;
import com.pnt.repository.UserRepo;
import com.pnt.service.InternService;
import com.pnt.service.UserService;

@RestController
@RequestMapping("/intern")
@CrossOrigin("*")
public class InternController {
	@Autowired
	private InternService internService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepo userRepo;
	
	//Thêm thông tin đăng ký thực tập
	@PostMapping("/")
	public ResponseEntity<?> addIntern(@RequestBody Intern intern) {
		Intern internData = this.internService.addIntern(intern);
		return new ResponseEntity<>(internData, HttpStatus.CREATED);	
	}
	
	//Lấy thông tin đăng ký thực tập
	@GetMapping("/") 
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.internService.getAll());
	}
	
	// Cập nhật thông tin đăng ký thực tập
	@PutMapping("/")
	public ResponseEntity<Intern> updateintern(@RequestBody Intern intern) {
		Intern internData = internService.updateIntern(intern);
		return new ResponseEntity<>(internData, HttpStatus.OK);
	}
	
	// Xóa thông tin đăng ký thực tập
	@DeleteMapping("/{id}") 
	public ResponseEntity<?> deleteintern(@PathVariable("id") Long id){
		internService.deleteIntern(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
//	@PostMapping("/")
//	public ResponseEntity<?> addIntern(@RequestBody Intern intern, Principal principal) {
//		User user = this.userService.getUser(principal.getName());
//		intern.setUser(user);
//		user.getInterns().add(intern);
//		User userData = this.userRepo.save(user);
//		return new ResponseEntity<>(userData, HttpStatus.CREATED);	
//	}
}
