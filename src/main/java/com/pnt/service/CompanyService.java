package com.pnt.service;

import java.util.List;

import com.pnt.model.company.Company;

public interface CompanyService {
	public Company addCompany(Company company);
	public Company updateCompany(Company company);
	public List<Company> getAllCompany();
	public void deleteCompany(Long id);
	public Company findCompanyById(Long id);
}
