package com.pnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pnt.model.company.Company;


public interface CompanyRepo extends JpaRepository<Company, Long>{

	Company findCompanyByCid(Long cid);

	void deleteCompanyByCid(Long cid);

	@Query(value = "SELECT COUNT(*) FROM company", 
			nativeQuery =true)
	int getNumberCompany();
}
