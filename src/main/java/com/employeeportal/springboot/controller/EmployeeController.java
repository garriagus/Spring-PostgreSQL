package com.employeeportal.springboot.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.employeeportal.springboot.model.EmployeeList;
import com.employeeportal.springboot.model.emp.Employee;
import com.employeeportal.springboot.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

	@GetMapping
	public ResponseEntity<EmployeeList> findAll() {
		EmployeeList employeeList = new EmployeeList();
		employeeList.items = service.findAll();
		return ResponseEntity.ok().body(employeeList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> findById(@PathVariable int id) {
		Employee employee = service.findById(id);
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping
	public ResponseEntity<Employee> save(@RequestBody Employee employee) {
		Employee savedEmployee = service.save(employee);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}")
				.buildAndExpand(savedEmployee.getId()).toUri();
		return ResponseEntity.created(uri).body(savedEmployee);
	}

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable int id, @RequestBody Employee employee) {
        Employee updatedEmployee = service.update(id, employee);
        return ResponseEntity.ok().body(updatedEmployee);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }
}