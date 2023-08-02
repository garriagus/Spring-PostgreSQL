package com.employeeportal.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeportal.springboot.model.Door;

@Repository
public interface DoorRepository extends JpaRepository<Door, Long> {
	// Agrega métodos personalizados si los necesitas
}