package com.pnt.service;

import java.util.List;
import java.util.Set;

import com.pnt.model.company.Company;
import com.pnt.model.dto.CompanyDto;

public interface CompanyService {
	public Company addCompany(Company company);
	public Company updateCompany(Company company);
	public Set<Company> getAllCompany();
	public void deleteCompany(Long id);
	public Company findCompanyById(Long id);
	public List<CompanyDto> getCompanyExport();
}
