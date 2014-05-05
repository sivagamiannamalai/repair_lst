package com.pdxcycle9.repair_lst.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "findAllRepairFacilities", query = "SELECT rf FROM RepairFacility rf"),
				@NamedQuery(name = "findRepairFacilityById", query = "SELECT rf FROM RepairFacility rf WHERE rf.id = :id") })
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
	
	
	@ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "address_fk", nullable = false, referencedColumnName = "address_id")
    private Address address;

	@ManyToMany(fetch= FetchType.EAGER)
	@JoinTable(name = "repair_facility_specialization", 
	joinColumns = { @JoinColumn(name = "repair_facility_fk") }, 
	inverseJoinColumns = { @JoinColumn(name = "specialization_fk") })
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

	public void setRating(double rating) {
		this.rating = rating;
	}


	public Collection<Specialization> getSpecializations() {
		return specializations;
	}

	public void setSpecializations(Collection<Specialization> specializations) {
		this.specializations = specializations;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "RepairFacility [id=" + id + ", name=" + name + ", phone="
				+ phone + ", hourlyRate=" + hourlyRate + ", rating=" + rating
				+ ", address=" + address + ", specializations="
				+ specializations + "]";
	}
	
	

}
