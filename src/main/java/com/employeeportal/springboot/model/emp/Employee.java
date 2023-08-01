package com.employeeportal.springboot.model.emp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Employee implements Serializable {

	@Id
	@GeneratedValue
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private int age;

	@Column(name = "no_of_children")
	private int noOfChildren;
	private boolean spouse;

	@JsonManagedReference
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "address")
	private Address address;

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REMOVE })
	private List<PhoneNumber> phoneNumbers;

	@ElementCollection
	@CollectionTable(name = "hobbies", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "hobby")
	private List<String> hobbies = new ArrayList<>();

	public Map<String, ?> getId() {
		// TODO Auto-generated method stub
		return null;
	}

}