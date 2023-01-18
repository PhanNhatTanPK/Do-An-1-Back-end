package com.pnt.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pnt.exception.UserFoundException;
import com.pnt.model.user.Role;
import com.pnt.model.user.User;
import com.pnt.model.user.UserRole;
import com.pnt.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//Tạo người dùng
	@PostMapping("/student")
	public User createUser(@RequestBody User user) throws Exception {
		user.setProfile("https://cdn-icons-png.flaticon.com/128/3177/3177440.png");
		// Mã hóa mật khẩu
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		Set<UserRole> roles = new HashSet<>();
		Role role = new Role();
		role.setId(3L);
		role.setRoleName("STUDENT");
		
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		
		roles.add(userRole);
		return this.userService.createUser(user, roles);
	}
	
	@PostMapping("/teacher")
	public User AddTeacher(@RequestBody User user) throws Exception {
		user.setProfile("https://cdn-icons-png.flaticon.com/128/3177/3177440.png");
		// Mã hóa mật khẩu
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		Set<UserRole> roles = new HashSet<>();
		Role role = new Role();
		role.setId(2L);
		role.setRoleName("TEACHER");
		
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		
		roles.add(userRole);
		return this.userService.createUser(user, roles);
	}
	
	// Lấy thông tin người dùng bằng userCode
	@GetMapping("/{userCode}")
	public User getUser(@PathVariable("userCode") String userCode) {
		return this.userService.getUser(userCode);
	}
	
	// Lấy thông tin sinh viên
	@GetMapping("/student")
	public List<User> getAllStudent() {
		return this.userService.getAllStudent();
	}
		
	// Lấy thông tin giảng viên
	@GetMapping("/teacher")
	public List<User> getAllTeacher() {
		return this.userService.getAllTeacher();
	}
	
	// Lấy thông tin quản lý
	@GetMapping("/infoAdmin")
	public List<User> getInfoAdmin() {
		return this.userService.getInfoAdmin();
	}
	
	// Xóa người dùng
	@DeleteMapping("/{userCode}")
	public void deleteUser(@PathVariable("userCode") String userCode) {
		 this.userService.deleteUserByUserCode(userCode);
	}
	
	// Cập nhật thông tin người dùng
	@PutMapping("/profile")
	public ResponseEntity<User> updateCompany(@RequestBody User user) {
		User userData = userService.updateUser(user);
		return new ResponseEntity<>(userData, HttpStatus.OK);
	}
	
	
	@ExceptionHandler(UserFoundException.class)
	public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
		return new ResponseEntity<String>(ex.toString(), HttpStatus.BAD_REQUEST);
	}
}
