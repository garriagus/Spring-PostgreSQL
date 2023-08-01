package com.employeeportal.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeportal.springboot.model.emp.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	void setFirstName(long employeeId, String firstName);
}