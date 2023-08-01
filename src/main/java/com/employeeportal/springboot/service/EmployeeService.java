package com.employeeportal.springboot.service;

import java.util.List;

import com.employeeportal.springboot.model.emp.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	Employee findById(int id);

	Employee save(Employee sportsIcon);

	Employee update(int id, Employee employee);

	void delete(int id);

}