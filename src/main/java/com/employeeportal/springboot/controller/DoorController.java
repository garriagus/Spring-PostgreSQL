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

import com.employeeportal.springboot.model.Door;
import com.employeeportal.springboot.service.DoorService;

@RestController
@RequestMapping("/api/doors")
public class DoorController {

	private final DoorService doorService;

	@Autowired
	public DoorController(DoorService doorService) {
		this.doorService = doorService;
	}

	@GetMapping
	public List<Door> getAllDoors() {
		return doorService.getAllDoors();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Door> getDoorById(@PathVariable Long id) {
		Optional<Door> door = doorService.getDoorById(id);
		return door.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Door> createDoor(@RequestBody Door door) {
		Door savedDoor = doorService.saveDoor(door);
		return new ResponseEntity<>(savedDoor, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Door> updateDoor(@PathVariable Long id, @RequestBody Door door) {
		Optional<Door> existingDoor = doorService.getDoorById(id);
		if (existingDoor.isPresent()) {
			door.setId(id);
			Door updatedDoor = doorService.saveDoor(door);
			return new ResponseEntity<>(updatedDoor, HttpStatus.OK);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDoor(@PathVariable Long id) {
		Optional<Door> existingDoor = doorService.getDoorById(id);
		if (existingDoor.isPresent()) {
			doorService.deleteDoorById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
