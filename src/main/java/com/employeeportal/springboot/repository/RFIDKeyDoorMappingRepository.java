package com.employeeportal.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeportal.springboot.model.RFIDKeyDoorMapping;

@Repository
public interface RFIDKeyDoorMappingRepository extends JpaRepository<RFIDKeyDoorMapping, Long> {
	// Agrega métodos personalizados si los necesitas
}