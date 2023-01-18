package com.pnt.service;

import java.util.List;
import java.util.Set;

import com.pnt.model.dto.UserDto;
import com.pnt.model.user.User;
import com.pnt.model.user.UserRole;

public interface UserService {
	//Tạo user
	public User createUser(User userData, Set<UserRole> userRoles) throws Exception;
	
	// Lấy thông tin user
	public User getUser(String userCode);
	
	// Lấy thông tin sinh viên
	public List<User> getAllStudent();
	
	// Lấy thông tin sinh viên xuất file excel
	public List<UserDto> getStudentExport();
	
	//Lấy thông tin giảng viên
	public List<User> getAllTeacher();
	
	//Lấy thông tin quản lý
	public List<User> getInfoAdmin();
	
	// Sửa thông tin user
	public User updateUser(User user);
	
	// Xóa user
	public void deleteUserByUserCode(String userCode);
	
}
