package com.pnt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pnt.model.dto.UserDto;

public interface UserDtoRepo extends JpaRepository<UserDto, Long>{
	@Query(value = "SELECT users.*, company_address, company_name, intern.* FROM users, company, intern where users.user_code = intern.user_code and intern.company_cid = company.cid", 
			nativeQuery =true)
	List<UserDto> getStudentExport();
}
