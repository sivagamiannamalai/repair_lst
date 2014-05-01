package com.pdxcycle9.repair_lst.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name="address")
public class Address implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="address_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="street",  nullable = false)
	private String street;
	
	@Column(name="city",  nullable = false)
	private String city;
	
	public Address() {
		super();
	}

	public Address(int id) {
		super();
		this.id = id;
	}

	@Column(name="state",  nullable = false)
	private String state;

	@Column(name = "zip_code", nullable = false)
	private String zip;
	

	/*
	 * Getters and setters for the AddressEntity variables
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address[id = " + id + " , street = " + street + " ,city = "
				+ city + " , state = " + state + " ,zip = " + zip + "]";

	}

}
