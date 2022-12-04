package com.pnt.service;

import java.util.Set;

import com.pnt.model.company.Company;
import com.pnt.model.company.Job;


public interface JobService {
	public Job addJob(Job job);
	public Job updateJob(Job job);
	public Set<Job> getAllJob();
	public Job getJob(Long id);
	public Set<Job> getJobOfCompany(Company company);
	public void deleteJob(Long id);
}
