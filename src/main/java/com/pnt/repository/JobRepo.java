package com.pnt.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pnt.model.company.Company;
import com.pnt.model.company.Job;

public interface JobRepo extends JpaRepository<Job, Long>{

	Set<Job> findByCompany(Company company);
	Job findByJid(Long jid);
	
	@Query(value = "SELECT job.jid, quantity, language, time, request, note, description, company_cid, company.company_name "
			+ "FROM job, company WHERE job.company_cid = company.cid", nativeQuery =true)
	List<Job> getAllJob();

}
