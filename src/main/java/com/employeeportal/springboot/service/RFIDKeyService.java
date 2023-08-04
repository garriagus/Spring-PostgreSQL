package com.employeeportal.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeportal.springboot.model.RFIDKey;
import com.employeeportal.springboot.repository.RFIDKeyRepository;

@Service
public class RFIDKeyService {

	private final RFIDKeyRepository rfidKeyRepository;

	@Autowired
	public RFIDKeyService(RFIDKeyRepository rfidKeyRepository) {
		this.rfidKeyRepository = rfidKeyRepository;
	}

	public List<RFIDKey> getAllRFIDKeys() {
		return rfidKeyRepository.findAll();
	}

	public Optional<RFIDKey> getRFIDKeyById(Long id) { // Cambiado a Long
		return rfidKeyRepository.findById(id);
	}

	public RFIDKey saveRFIDKey(RFIDKey rfidKey) {
		return rfidKeyRepository.save(rfidKey);
	}

	public void deleteRFIDKeyById(Long id) { // Cambiado a Long
		rfidKeyRepository.deleteById(id);
	}
	// Aquí puedes agregar otros métodos del servicio si es necesario

}
