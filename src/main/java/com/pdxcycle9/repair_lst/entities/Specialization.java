package com.pdxcycle9.repair_lst.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "specialization")
public class Specialization {
	
	public Specialization() {
		
	}
	
	public Specialization(int id) {
		
	}
	
	@Id @GeneratedValue
	@Column(name = "specialization_id", unique = true, nullable = false)
	private int id;	
	
	@Column(name = "type")
	private String type;
	
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
