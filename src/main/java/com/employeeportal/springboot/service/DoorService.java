package com.employeeportal.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeportal.springboot.model.Door;
import com.employeeportal.springboot.repository.DoorRepository;

@Service
public class DoorService {

	private final DoorRepository doorRepository;

	@Autowired
	public DoorService(DoorRepository doorRepository) {
		this.doorRepository = doorRepository;
	}

	public List<Door> getAllDoors() {
		return doorRepository.findAll();
	}

	public Optional<Door> getDoorById(long id) {
		return doorRepository.findById(id);
	}

	public Door saveDoor(Door door) {
		return doorRepository.save(door);
	}

	public void deleteDoorById(long id) {
		doorRepository.deleteById(id);
	}

	// Aquí puedes agregar otros métodos del servicio si es necesario

}
