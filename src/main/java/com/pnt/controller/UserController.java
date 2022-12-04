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
	@PostMapping("/register")
	public User createUser(@RequestBody User user) throws Exception {
		user.setProfile("https://th.bing.com/th/id/R.945f33b643f2ceffcdae90fb57c61854?rik=XcI0SYBgSefoCA&riu=http%3a%2f%2fgetdrawings.com%2ffree-icon-bw%2fanonymous-avatar-icon-19.png&ehk=5n%2buJG66CeLQZsmhaMt8gag5rXuM3TdebAL6W35K1E4%3d&risl=&pid=ImgRaw&r=0");
		// Mã hóa mật khẩu
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		Set<UserRole> roles = new HashSet<>();
		Role role = new Role();
		role.setId(2L);
		role.setRoleName("USER");
		
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		
		roles.add(userRole);
		return this.userService.createUser(user, roles);
	}
	
	@PostMapping("/addTeacher")
	public User AddTeacher(@RequestBody User user) throws Exception {
		user.setProfile("https://th.bing.com/th/id/R.945f33b643f2ceffcdae90fb57c61854?rik=XcI0SYBgSefoCA&riu=http%3a%2f%2fgetdrawings.com%2ffree-icon-bw%2fanonymous-avatar-icon-19.png&ehk=5n%2buJG66CeLQZsmhaMt8gag5rXuM3TdebAL6W35K1E4%3d&risl=&pid=ImgRaw&r=0");
		// Mã hóa mật khẩu
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		Set<UserRole> roles = new HashSet<>();
		Role role = new Role();
		role.setId(3L);
		role.setRoleName("TEACHER");
		
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		
		roles.add(userRole);
		return this.userService.createUser(user, roles);
	}
	
	// Lấy thông tin người dùng
	@GetMapping("/{userCode}")
	public User getUser(@PathVariable("userCode") String userCode) {
		return this.userService.getUser(userCode);
	}
	
	// Lấy thông tin người dùng
	@GetMapping("/student/all")
	public List<User> getAllStudent() {
		return this.userService.getAllStudent();
	}
		
	// Lấy thông tin người dùng
	@GetMapping("/teacher/all")
	public List<User> getAllTeacher() {
		return this.userService.getAllTeacher();
	}
	
	// Xóa người dùng
	@DeleteMapping("/delete/{userCode}")
	public void deleteUser(@PathVariable("userCode") String userCode) {
		 this.userService.deleteUserByUserCode(userCode);
	}
	
	// Cập nhật thông tin người dùng
	@PutMapping("/profile/update")
	public ResponseEntity<User> updateCompany(@RequestBody User user) {
		User userData = userService.updateUser(user);
		return new ResponseEntity<>(userData, HttpStatus.OK);
	}
	
	@ExceptionHandler(UserFoundException.class)
	public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
		return new ResponseEntity<String>(ex.toString(), HttpStatus.BAD_REQUEST);
	}
}
