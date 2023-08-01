package com.employeeportal.springboot.model.emp;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Address implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "street_address")
    private String streetAddress;
    private String city;
    private String state;
    private String country;

    @Column(name = "postal_address")
    private String postalCode;

    @JsonBackReference
    @OneToOne(mappedBy="address", 
    		cascade = { 
    	    		CascadeType.MERGE,
    	    		CascadeType.PERSIST,
    	    		CascadeType.REMOVE
    })
    private Employee employee;
}