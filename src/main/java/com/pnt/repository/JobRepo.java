package com.pnt.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pnt.model.company.Company;
import com.pnt.model.company.Job;

public interface JobRepo extends JpaRepository<Job, Long>{

	Job findById(Long id);

	Set<Job> findByCompany(Company company);

}
