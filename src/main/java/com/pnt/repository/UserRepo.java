package com.pnt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pnt.model.user.User;

public interface UserRepo extends JpaRepository<User, Long>{

	User findByUserCode(String userCode);

	void deleteByUserCode(String userCode);
	
	@Query(value = "SELECT * FROM users INNER JOIN user_role ON users.id = user_role.user_id WHERE user_role.role_id = 3", 
			nativeQuery =true)
	List<User> getAllTeacher();
	
	@Query(value = "SELECT * FROM users INNER JOIN user_role ON users.id = user_role.user_id WHERE user_role.role_id = 2", 
			nativeQuery =true)
	List<User> getAllStudent();
}
