package com.pdxcycle9.repair_lst.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "findAllRepairFacilities", query = "SELECT rf FROM RepairFacility rf") })
@Entity
@Table(name = "repair_facility")
public class RepairFacility implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "repair_facility_id", unique = true, nullable = false)
	private int id;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Column(name = "phone", nullable = false)
	private String phone;

	@Column(name = "hourly_rate", nullable = false)
	private BigDecimal hourlyRate;

	@Column(name = "rating")
	private double rating;

	@JoinColumn(name="address_id")
	@Column(name = "address_fk")
	private Address addressId;	

	@ManyToMany
	@JoinTable(name = "repair_facility_specialization", joinColumns = { @JoinColumn(name = "repair_facility_id") }, inverseJoinColumns = { @JoinColumn(name = "specialization_id") })
	private Collection<Specialization> specializations;

	public RepairFacility() {

	}

	/*
	 * Getters and setters for the RepairFacility entity variables
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BigDecimal getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(BigDecimal hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}



	public Collection<Specialization> getSpecializations() {
		return specializations;
	}

	public void setSpecializations(Collection<Specialization> specializations) {
		this.specializations = specializations;
	}

	/**
	 * @return the addressId
	 */
	public Address getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RepairFacility [id=" + id + ", name=" + name + ", phone="
				+ phone + ", hourlyRate=" + hourlyRate + ", rating=" + rating
				+ ", addressId=" + addressId + ", specializations="
				+ specializations + "]";
	}

}
