package com.employeeportal.springboot.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class RFIDKey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "serial_number")
	private String serialNumber;

	public enum KeyType {
		KEY_RING, CARD
	}

	@Enumerated(EnumType.STRING)
	private KeyType keyType;

	@Column(name = "joiningDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate joiningDate;

	@OneToOne(mappedBy = "rfidKey")
	private Employee employee;

	@OneToMany(mappedBy = "rfidKey")
	private List<RFIDKeyDoorMapping> rfidKeyDoors;

	public RFIDKey() {
	}

	public RFIDKey(int id, String serialNumber, KeyType keyType, LocalDate joiningDate, Employee employee,
			List<RFIDKeyDoorMapping> rfidKeyDoors) {
		super();
		this.id = id;
		this.serialNumber = serialNumber;
		this.keyType = keyType;
		this.joiningDate = joiningDate;
		this.employee = employee;
		this.rfidKeyDoors = rfidKeyDoors;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public KeyType getKeyType() {
		return keyType;
	}

	public void setKeyType(KeyType keyType) {
		this.keyType = keyType;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<RFIDKeyDoorMapping> getRfidKeyDoors() {
		return rfidKeyDoors;
	}

	public void setRfidKeyDoors(List<RFIDKeyDoorMapping> rfidKeyDoors) {
		this.rfidKeyDoors = rfidKeyDoors;
	}

}