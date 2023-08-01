package com.employeeportal.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeportal.springboot.model.RFIDKey;

@Repository
public interface RFIDKeyRepository extends JpaRepository<RFIDKey, Long> {
}