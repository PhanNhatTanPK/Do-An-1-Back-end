package com.pnt.service.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnt.model.company.Company;
import com.pnt.repository.CompanyRepo;
import com.pnt.service.CompanyService;

@Service
@Transactional
public class CompanyServiceImp implements CompanyService{
	@Autowired
	private CompanyRepo companyRepo;
		
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
	public List<Company> getAllCompany() {
		// TODO Auto-generated method stub
		return companyRepo.findAll();
	}

	@Override
	public void deleteCompany(Long id) {
		// TODO Auto-generated method stub
		this.companyRepo.deleteCompanyById(id);
	}

	@Override
	public Company findCompanyById(Long id) {
		// TODO Auto-generated method stub
		return companyRepo.findCompanyById(id);
	}

	

}
