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

import com.employeeportal.springboot.model.Area;
import com.employeeportal.springboot.service.AreaService;

@RestController
@RequestMapping("/api/areas")
public class AreaController {

	private final AreaService areaService;

	@Autowired
	public AreaController(AreaService areaService) {
		this.areaService = areaService;
	}

	@GetMapping
	public List<Area> getAllAreas() {
		return areaService.getAllAreas();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Area> getAreaById(@PathVariable Long id) {
		Optional<Area> area = areaService.getAreaById(id);
		return area.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Area> createArea(@RequestBody Area area) {
		Area savedArea = areaService.saveArea(area);
		return new ResponseEntity<>(savedArea, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Area> updateArea(@PathVariable Long id, @RequestBody Area area) {
		Optional<Area> existingArea = areaService.getAreaById(id);
		if (existingArea.isPresent()) {
			area.setId(id);
			Area updatedArea = areaService.saveArea(area);
			return new ResponseEntity<>(updatedArea, HttpStatus.OK);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteArea(@PathVariable Long id) {
		Optional<Area> existingArea = areaService.getAreaById(id);
		if (existingArea.isPresent()) {
			areaService.deleteAreaById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
