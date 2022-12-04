package com.pnt.service.imp;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnt.model.company.Company;
import com.pnt.model.company.Job;
import com.pnt.repository.JobRepo;
import com.pnt.service.JobService;

@Service
public class JobServiceImp implements JobService{
	@Autowired
	private JobRepo jobRepo;

	@Override
	public Job addJob(Job job) {
		// TODO Auto-generated method stub
		return this.jobRepo.save(job);
	}

	@Override
	public Job updateJob(Job job) {
		// TODO Auto-generated method stub
		return this.jobRepo.save(job);
	}

	@Override
	public Set<Job> getAllJob() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.jobRepo.findAll());
	}

	@Override
	public Job getJob(Long id) {
		// TODO Auto-generated method stub
		return this.jobRepo.findById(id);
	}
	
	@Override
	public Set<Job> getJobOfCompany(Company company) {
		// TODO Auto-generated method stub
		return this.jobRepo.findByCompany(company);
	}

	@Override
	public void deleteJob(Long id) {
		// TODO Auto-generated method stub
		this.jobRepo.delete(id);
	}
}
