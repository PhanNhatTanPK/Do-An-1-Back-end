package com.pnt.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pnt.config.JwtUtils;
import com.pnt.exception.UserNotFoundException;
import com.pnt.model.user.JwtRequest;
import com.pnt.model.user.JwtResponse;
import com.pnt.model.user.User;
import com.pnt.service.implement.UserDetailServiceImp;

@RestController
@CrossOrigin("*")
public class AuthenticateController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailServiceImp userDetailServiceImp;
	 @Autowired
	 private JwtUtils jwtUtils;
	
	//Tạo Token
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		try {
			authenticate(jwtRequest.getUserCode(),jwtRequest.getPassword());
		} catch (UserNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new UserNotFoundException();
		}
		
		UserDetails userDetails = this.userDetailServiceImp.loadUserByUsername(jwtRequest.getUserCode());
		String token = this.jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String userCode, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCode, password));
		} catch (DisabledException e) {
			// TODO: handle exception
			throw new Exception("USER DISABLED: " +e.getMessage());			
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			throw new Exception("INVALID CREDENTIAL: "+ e.getMessage());
		}
	}
	
	// Trả về thông tin chi tiết của user hiện tại đang được chon
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		return (User)this.userDetailServiceImp.loadUserByUsername(principal.getName());
	}
}
