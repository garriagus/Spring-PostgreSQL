package com.employeeportal.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeportal.springboot.model.Area;

public interface AreaRepository extends JpaRepository<Area, Long> {
	// Agrega métodos personalizados si los necesitas
}