package com.pdxcycle9.repair_lst.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="specialization")
public class Specialization {
	
	@Id
	private int id;
	
	@Column
	private String type;
	
	public Specialization() {

		
	}

	public Specialization(int id) {

		this.id = id;
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
}
