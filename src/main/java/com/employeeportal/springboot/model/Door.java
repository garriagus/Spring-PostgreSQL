package com.employeeportal.springboot.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "doors")
public class Door {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "ip_address", unique = true)
	private String ipAddress;

	@Column(name = "door_name")
	private String doorName;

	@ManyToOne
	@JoinColumn(name = "area_id")
	private Area area;

	@OneToMany(mappedBy = "door")
	private List<RFIDKeyDoorMapping> rfidKeyDoors;

	public Door() {
		super();
	}

	public Door(long id, String ipAddress, String doorName, Area area, List<RFIDKeyDoorMapping> rfidKeyDoors) {
		super();
		this.id = id;
		this.ipAddress = ipAddress;
		this.doorName = doorName;
		this.area = area;
		this.rfidKeyDoors = rfidKeyDoors;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getDoorName() {
		return doorName;
	}

	public void setDoorName(String doorName) {
		this.doorName = doorName;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<RFIDKeyDoorMapping> getRfidKeyDoors() {
		return rfidKeyDoors;
	}

	public void setRfidKeyDoors(List<RFIDKeyDoorMapping> rfidKeyDoors) {
		this.rfidKeyDoors = rfidKeyDoors;
	}

}
