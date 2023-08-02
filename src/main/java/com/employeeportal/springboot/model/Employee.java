package com.employeeportal.springboot.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "joiningDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate joiningDate;

	@Column(name = "retiringDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate retiringDate;

	@Column(name = "no_of_children")
	private int noOfChildren;

	@ManyToOne
	@JoinColumn(name = "area_id")
	private Area area;

	@OneToOne
	@JoinColumn(name = "rfid_key_id")
	private RFIDKey rfidKey;

	public Employee() {
	}

	public Employee(String firstName, String lastName, String gender, LocalDate joiningDate, LocalDate retiringDate,
			int noOfChildren, Area area, RFIDKey rfidKey) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.joiningDate = joiningDate;
		this.retiringDate = retiringDate;
		this.noOfChildren = noOfChildren;
		this.area = area;
		this.rfidKey = rfidKey;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public LocalDate getRetiringDate() {
		return retiringDate;
	}

	public void setRetiringDate(LocalDate retiringDate) {
		this.retiringDate = retiringDate;
	}

	public int getNoOfChildren() {
		return noOfChildren;
	}

	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public RFIDKey getRfidKey() {
		return rfidKey;
	}

	public void setRfidKey(RFIDKey rfidKey) {
		this.rfidKey = rfidKey;
	}

}