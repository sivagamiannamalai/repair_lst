package com.pdxcycle9.repair_lst.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

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

import org.hibernate.annotations.Type;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

@NamedQueries({ 
//				@NamedQuery(name = "findAllRepairItems", query = "SELECT ri FROM RepairItem ri"),
//				@NamedQuery(name = "findRepairItemById", query = "SELECT ri FROM RepairItem ri WHERE ri.id = :id"),
//				@NamedQuery(name = "getRepairFacilityRatingByName", query = "SELECT lst_repairtracker.getaverageratingbyname('%:name%');")
})
@Entity
@Table(name = "repair_item")
public class RepairItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "repair_item_id")
	private int id;

	@Column(name = "description", unique = true, nullable = true)
	private String description;

	@Column(name = "date", nullable = false)
	@Type(type = "date")
	private Date date;

	@Column(name = "hourly_rate", nullable = false)
	private BigDecimal hourlyRate;
	
	@Column(name = "labor_hours", nullable = false)
	private int laborHours;
	
	@Column(name = "mileage", nullable = false)
	private int mileage;
	
	@Column(name = "rating", nullable = false)
	private int rating;

	@Column(name = "user_fk", nullable = false)
	private int userId;
	
	@Column(name = "repair_type_fk", nullable = false)
	private int repairTypeId;
	
	@Column(name = "repair_facility_fk", nullable = false)
	private int repairFacilityId;
	
	@Column(name = "vehicle_fk", nullable = false)
	private int vehicleId;
	
	

	@ManyToMany(fetch= FetchType.EAGER)
    @JsonManagedReference
	@JoinTable(name = "repair_item_parts", 
	joinColumns = { @JoinColumn(name = "repair_item_fk") }, 
	inverseJoinColumns = { @JoinColumn(name = "part_fk") })
	private Collection<Part> parts;

	private String dateData;

	public RepairItem() {

	}
	
	public RepairItem(int id) {
		this.id = id;
	}
	
	/**
	 * getters and setters for Repair Item
	 * @return
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * getters and setters for date object, and casting a string to a date 
	 * @param date
	 */
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getDateData() {
		return dateData;
	}
	
	public void setDateData(String dateData) {
		this.dateData = dateData;
	}

	public BigDecimal getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(BigDecimal hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public int getLaborHours() {
		return laborHours;
	}

	public void setLaborHours(int laborHours) {
		this.laborHours = laborHours;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRepairTypeId() {
		return repairTypeId;
	}

	public void setRepairTypeId(int repairTypeId) {
		this.repairTypeId = repairTypeId;
	}

	public int getRepairFacilityId() {
		return repairFacilityId;
	}

	public void setRepairFacilityId(int repairFacilityId) {
		this.repairFacilityId = repairFacilityId;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Collection<Part> getParts() {
		return parts;
	}

	public void setParts(Collection<Part> parts) {
		this.parts = parts;
	}

	@Override
	public String toString() {
		return "RepairItem [id=" + id + ", description=" + description + ", date="
				+ date + ", hourlyRate=" + hourlyRate + ", laborHours=" + laborHours + ", mileage="
				+ mileage + ", rating=" + rating + ", userId=" + userId + ", repairTypeId="
				+ repairTypeId + ", repairFacilityId=" + repairFacilityId + ", vehicleId=" + vehicleId + ","
				+ "parts=" + parts + "]";
	}

}
