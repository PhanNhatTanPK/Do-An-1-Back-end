package com.pnt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pnt.model.dto.CompanyDto;

public interface CompanyDtoRepo  extends JpaRepository<CompanyDto, Long>{
	@Query(value = "select company.*, (Select Count(intern.company_cid) from intern where company.cid = intern.company_cid) as number from company", 
			nativeQuery =true)
	List<CompanyDto> getCompanyExport();
	
}
