package com.pnt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pnt.model.report.Report;

public interface ReportRepo extends JpaRepository<Report, Long>{
	
	@Query(value = "SELECT * FROM report WHERE report.user_code = :userCode", 
			nativeQuery =true)
	List<Report> getReportByUserCode(@Param("userCode") String userCode);
}
