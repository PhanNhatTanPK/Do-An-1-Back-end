package com.pnt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pnt.model.dto.ResultDto;


public interface ResultDtoRepo extends JpaRepository<ResultDto, Long>{
	@Query(value = "SELECT users.id, full_name, total_point FROM users, result WHERE users.user_code = result.user_code", 
			nativeQuery =true)
	List<ResultDto> getTotalPointExport();
}
