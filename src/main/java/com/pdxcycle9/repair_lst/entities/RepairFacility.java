package com.pdxcycle9.repair_lst.entities;

<<<<<<< HEAD
import java.util.Collection;
=======
import java.math.BigDecimal;
>>>>>>> b3dcd3976ea9b28f8fe99c14c0f23d82e19f4af1
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
		private BigDecimal hourlyRate;
		
		@Column (name = "rating")
		private double rating;
		
		@Column( name = "address_fk")
		private int addressId;
			 
		
		
<<<<<<< HEAD
		 @ManyToMany
		 @Target(RepairFacility.class)	 
=======
		/* @ManyToMany
>>>>>>> b3dcd3976ea9b28f8fe99c14c0f23d82e19f4af1
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
