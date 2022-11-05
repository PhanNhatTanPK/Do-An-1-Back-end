package com.pnt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pnt.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	void deleteEmpById(Long id);

	Optional<Employee> findEmpById(Long id);

}
