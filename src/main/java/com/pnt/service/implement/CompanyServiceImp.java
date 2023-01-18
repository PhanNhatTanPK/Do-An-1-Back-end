package com.pnt.service.implement;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnt.model.company.Company;
import com.pnt.model.dto.CompanyDto;
import com.pnt.repository.CompanyDtoRepo;
import com.pnt.repository.CompanyRepo;
import com.pnt.service.CompanyService;

@Service
@Transactional
public class CompanyServiceImp implements CompanyService{
	@Autowired
	private CompanyRepo companyRepo;
	@Autowired
	private CompanyDtoRepo companyDtoRepo;
		
	@Override
	public Company addCompany(Company company) {
		// TODO Auto-generated method stub
		return companyRepo.save(company);
	}

	@Override
	public Company updateCompany(Company company) {
		// TODO Auto-generated method stub
		return companyRepo.save(company);
	}

	@Override
	public Set<Company> getAllCompany() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(this.companyRepo.findAll());
	}

	@Override
	public void deleteCompany(Long id) {
		// TODO Auto-generated method stub
		this.companyRepo.deleteCompanyByCid(id);
	}

	@Override
	public Company findCompanyById(Long id) {
		// TODO Auto-generated method stub
		return companyRepo.findCompanyByCid(id);
	}

	@Override
	public List<CompanyDto> getCompanyExport() {
		// TODO Auto-generated method stub
		return this.companyDtoRepo.getCompanyExport();
	}

	

}
