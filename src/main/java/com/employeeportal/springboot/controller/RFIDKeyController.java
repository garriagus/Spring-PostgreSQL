package com.employeeportal.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeportal.springboot.model.RFIDKey;
import com.employeeportal.springboot.service.RFIDKeyService;

@RestController
@RequestMapping("/api/rfidkeys")
public class RFIDKeyController {

	private final RFIDKeyService rfidKeyService;

	@Autowired
	public RFIDKeyController(RFIDKeyService rfidKeyService) {
		this.rfidKeyService = rfidKeyService;
	}

	@GetMapping
	public List<RFIDKey> getAllRFIDKeys() {
		return rfidKeyService.getAllRFIDKeys();
	}

	@GetMapping("/{id}")
	public ResponseEntity<RFIDKey> getRFIDKeyById(@PathVariable Long id) {
		Optional<RFIDKey> rfidKey = rfidKeyService.getRFIDKeyById(id);
		return rfidKey.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<RFIDKey> createRFIDKey(@RequestBody RFIDKey rfidKey) {
		RFIDKey savedRFIDKey = rfidKeyService.saveRFIDKey(rfidKey);
		return new ResponseEntity<>(savedRFIDKey, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<RFIDKey> updateRFIDKey(@PathVariable Long id, @RequestBody RFIDKey rfidKey) {
		Optional<RFIDKey> existingRFIDKey = rfidKeyService.getRFIDKeyById(id);
		if (existingRFIDKey.isPresent()) {
			rfidKey.setId(id.intValue()); 
			RFIDKey updatedRFIDKey = rfidKeyService.saveRFIDKey(rfidKey);
			return new ResponseEntity<>(updatedRFIDKey, HttpStatus.OK);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRFIDKey(@PathVariable Long id) {
		Optional<RFIDKey> existingRFIDKey = rfidKeyService.getRFIDKeyById(id);
		if (existingRFIDKey.isPresent()) {
			rfidKeyService.deleteRFIDKeyById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
