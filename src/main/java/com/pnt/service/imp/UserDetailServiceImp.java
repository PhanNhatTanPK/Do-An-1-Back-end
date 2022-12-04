package com.pnt.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pnt.model.user.User;
import com.pnt.repository.UserRepo;

@Service
public class UserDetailServiceImp implements UserDetailsService{
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String userCode) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepo.findByUserCode(userCode);
		if(user == null) {
			System.out.println("User don't exist");
			throw new UsernameNotFoundException("User not found");
		}
		return user;
	}

}
