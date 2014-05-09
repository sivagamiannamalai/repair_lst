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
import javax.persistence.Table;

@Entity
@Table (name = "part")
public class Part implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column (name = "part_id")
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "manufacturer")
	private String manufacturer;
	
	@Column (name = "part_number")
	private String partNumber;
	
	@Column (name = "price")
	private BigDecimal price;
	
	@ManyToMany(fetch= FetchType.EAGER)
	@JoinTable(name = "repair_item_parts", 
	joinColumns = { @JoinColumn(name = "part_fk") }, 
	inverseJoinColumns = { @JoinColumn(name = "repair_item_fk") })
	private Collection<RepairItem> repairItems;
	
	
	/*
	 * Constructors
	 */
	public Part() {
		
	}
	
	public Part(int id) {
		this.id = id;
	}
	/*
	 * Getters and Setters for all fields
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

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Collection<RepairItem> getRepairItems() {
		return repairItems;
	}

	public void setRepairItems(Collection<RepairItem> repairItems) {
		this.repairItems = repairItems;
	}

	/*
	 * To String
	 */
	@Override
	public String toString() {
		return "Part [id=" + id + ", name=" + name + ", manufacturer="
				+ manufacturer + ", partNumber=" + partNumber + ", price="
				+ price + ", repairItems=" + repairItems + "]";
	}
	
}
