package com.pnt.service;

import java.util.List;

import com.pnt.model.company.Job;


public interface JobService {
	public Job addJob(Job job);
	public Job updateJob(Job job);
	public Job findById(Long id);
	public List<Job> getAllJob();
	public void deleteJob(Long id);
}
