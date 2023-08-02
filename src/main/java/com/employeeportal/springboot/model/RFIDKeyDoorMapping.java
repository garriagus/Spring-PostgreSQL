package com.employeeportal.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RFIDKeyDoorMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "rfid_key_id")
	private RFIDKey rfidKey;

	@ManyToOne
	@JoinColumn(name = "door_id")
	private Door door;

	public RFIDKeyDoorMapping() {
	}

	public RFIDKeyDoorMapping(Long id, RFIDKey rfidKey, Door door) {
		super();
		this.id = id;
		this.rfidKey = rfidKey;
		this.door = door;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RFIDKey getRfidKey() {
		return rfidKey;
	}

	public void setRfidKey(RFIDKey rfidKey) {
		this.rfidKey = rfidKey;
	}

	public Door getDoor() {
		return door;
	}

	public void setDoor(Door door) {
		this.door = door;
	}

}