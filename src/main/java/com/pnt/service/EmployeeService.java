package com.pnt.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnt.exception.UserNotFoundException;
import com.pnt.model.Employee;
import com.pnt.repository.EmployeeRepo;
@Service
@Transactional
public class EmployeeService {
	
	private final EmployeeRepo employeeRepo;
	
	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	public Employee addEmp(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}
	
	public List<Employee> finAllEmp(){
		return employeeRepo.findAll();
	}
	
	public Employee findEmById(Long id) {
		return employeeRepo.findEmpById(id).orElseThrow(() -> new UserNotFoundException("User by id"+ id +"was not found"));
	}
	
	public Employee updateEmp(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public void deleteEmp(Long id) {
		employeeRepo.deleteEmpById(id);
	}
}
