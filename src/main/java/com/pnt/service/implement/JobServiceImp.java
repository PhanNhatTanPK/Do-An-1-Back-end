package com.pnt.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Job> getAllJob() {
		// TODO Auto-generated method stub
		return this.jobRepo.getAllJob();
	}

	@Override
	public void deleteJob(Long id) {
		// TODO Auto-generated method stub
		this.jobRepo.delete(id);
	}

	@Override
	public Job findById(Long id) {
		// TODO Auto-generated method stub
		return this.jobRepo.findByJid(id);
	}
	
	
}
