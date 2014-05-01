package com.pdxcycle9.repair_lst.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Column;

@NamedQueries({ @NamedQuery(name = "findAllAdresses", query = "SELECT ad FROM Address ad") })
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
	
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;

	@Column(name="state")
	private String state;

	@Column(name = "zip_code")
	private String zip;
	
	public Address() {

	}

	public Address(int id) {

		this.id = id;
	}
	

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
