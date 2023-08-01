package com.employeeportal.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeportal.springboot.model.emp.Employee;
import com.employeeportal.springboot.repository.EmployeeRepository;
import com.employeeportal.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public List<Employee> findAll() {
		return repository.findAll();
	}


	@Override
	public Employee save(Employee employee) {
		return repository.save(employee);
	}


	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Employee update(int id, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}



}