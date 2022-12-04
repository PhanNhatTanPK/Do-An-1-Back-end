package com.pnt.service.imp;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnt.exception.UserFoundException;
import com.pnt.model.user.User;
import com.pnt.model.user.UserRole;
import com.pnt.repository.RoleRepo;
import com.pnt.repository.UserRepo;
import com.pnt.service.UserService;

@Service
@Transactional
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RoleRepo roleRepo;

	// Tao nguoi dung moi
	@Override
	public User createUser(User userData, Set<UserRole> userRoles) throws Exception {
		// TODO Auto-generated method stub
		User user = this.userRepo.findByUserCode(userData.getUserCode());
		if (user != null) {
			System.out.println("User Code already exist!");
			throw new UserFoundException();
		} else {
			for (UserRole userRole : userRoles) {
				roleRepo.save(userRole.getRole());
			}
			userData.getUserRoles().addAll(userRoles);
			user = this.userRepo.save(userData);
		}
		return user;
	}

	// Lấy thông tin người dùng thông qua Code
	@Override
	public User getUser(String userCode) {
		// TODO Auto-generated method stub
		return this.userRepo.findByUserCode(userCode);
	}

	@Override
	public void deleteUserByUserCode(String userCode) {
		// TODO Auto-generated method stub
		this.userRepo.deleteByUserCode(userCode);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return this.userRepo.save(user);
	}

	@Override
	public List<User> getAllStudent() {
		// TODO Auto-generated method stub
		return this.userRepo.getAllStudent();
	}

	@Override
	public List<User> getAllTeacher() {
		// TODO Auto-generated method stub
		return this.userRepo.getAllTeacher();
	}

}
