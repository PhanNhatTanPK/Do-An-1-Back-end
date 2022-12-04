package com.pnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pnt.model.company.Company;


public interface CompanyRepo extends JpaRepository<Company, Long>{

	Company findCompanyById(Long id);

	void deleteCompanyById(Long id);

}
