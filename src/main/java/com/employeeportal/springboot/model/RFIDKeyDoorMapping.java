package com.employeeportal.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rfid_key_door_mapping")
public class RFIDKeyDoorMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@ManyToOne
	@JoinColumn(name = "rfid_key_id")
	private RFIDKey rfidKey;

	@ManyToOne
	@JoinColumn(name = "door_id")
	private Door door;

	public RFIDKeyDoorMapping(RFIDKey rfidKey, Door door) {
		this.rfidKey = rfidKey;
		this.door = door;
	}
	
	
	
}