package com.pdxcycle9.repair_lst.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="vehicle")
public class Vehicle implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="vehicle_id")
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="year",  nullable = false)
	private String year;
	
	@Column(name="make",  nullable = false)
	private String make;
	
	@Column(name="model",  nullable = false)
	private String model;

	@Column(name = "vin", nullable = false)
	private String vin;
	
	@Column(name = "mileage", nullable = false)
	private int mileage;
	
	public Vehicle() {
	
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the vin
	 */
	public String getVin() {
		return vin;
	}

	/**
	 * @param vin the vin to set
	 */
	public void setVin(String vin) {
		this.vin = vin;
	}

	/**
	 * @return the mileage
	 */
	public int getMileage() {
		return mileage;
	}

	/**
	 * @param mileage the mileage to set
	 */
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	@Override
	public String toString() {
		return "Vehicle[id = " + id + ",year = " + year + " , make = " + make + " ,model = "
				+ model + " , vin = " + vin + " ,mileage = " + mileage + "]";

	}

	
}
