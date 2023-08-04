package com.employeeportal.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeportal.springboot.model.Area;
import com.employeeportal.springboot.repository.AreaRepository;

@Service
public class AreaService {

	private final AreaRepository areaRepository;

	@Autowired
	public AreaService(AreaRepository areaRepository) {
		this.areaRepository = areaRepository;
	}

	public List<Area> getAllAreas() {
		return areaRepository.findAll();
	}

	public Optional<Area> getAreaById(Long id) {
		return areaRepository.findById(id);
	}

	public Area saveArea(Area area) {
		return areaRepository.save(area);
	}

	public void deleteAreaById(Long id) {
		areaRepository.deleteById(id);
	}

	// Aquí puedes agregar otros métodos del servicio si es necesario

}
