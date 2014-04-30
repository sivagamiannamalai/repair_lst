package com.pdxcycle9.repair_lst.entities;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Target;


	@Entity
	@Table(name = "repair_facility")
	public class RepairFacility {	
		@Id @GeneratedValue
		@Column(name = "repair_facility_id", unique = true, nullable = false)
		private int id;	
		
		@Column(name = "name", unique = true, nullable = false)
		private String name;
		
		@Column(name = "phone", nullable = false)
		private String phone;
		
		@Column(name = "hourly_rate", nullable = false)
		private double hourlyRate;
		
		@Column (name = "rating")
		private double rating;
		
		@Column( name = "address_fk")
		private int addressId;
			 
		
		
		 @ManyToMany
		 @Target(RepairFacility.class)	 
		 @JoinTable(name = "repair_facility_specialization",
		          joinColumns={@JoinColumn(name="repair_facility_id")},
		          inverseJoinColumns={@JoinColumn(name="specialization_id")})
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
		public double getHourlyRate() {
			return hourlyRate;
		}
		public void setHourlyRate(double hourlyRate) {
			this.hourlyRate = hourlyRate;
		}
		public double getRating() {
			return rating;
		}
		public void setRating(int rating) {
			this.rating = rating;
		}

		public int getAddressId() {
			return addressId;
		}
		public void setAddressId(int addressId) {
			this.addressId = addressId;
		}
		
		public Collection<Specialization> getSpecializations() {
			return specializations;
		}

		public void setSpecializations(Collection<Specialization> specializations) {
			this.specializations = specializations;
		}
		
		public String toString() {
			return "RepairFacility[id " + id + ", name " + name + ", phone" + phone
					+ ", hourly rate " + hourlyRate + ", address " + addressId + "]";
		}

	    
}
