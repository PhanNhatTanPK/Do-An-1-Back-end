package com.pnt.service;

import java.util.List;
import java.util.Set;

import com.pnt.model.user.User;
import com.pnt.model.user.UserRole;

public interface UserService {
	//Tạo user
	public User createUser(User userData, Set<UserRole> userRoles) throws Exception;
	
	// Lấy thông tin user
	public User getUser(String userCode);
	
	// Lấy thông tin sinh viên
	public List<User> getAllStudent();
	
	//Lấy thoogn tin giảng viên
	public List<User> getAllTeacher();
	
	// Sửa thông tin user
	public User updateUser(User user);
	
	// Xóa user
	public void deleteUserByUserCode(String userCode);

	
}
