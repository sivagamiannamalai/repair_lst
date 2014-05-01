package com.pdxcycle9.repair_lst.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "findAllSpecializations", query = "SELECT sp FROM Specialization sp") })
@Entity
@Table(name ="specialization")
public class Specialization implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column (name = "specialization_id")
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private int id;
	
	@Column (name = "type")
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
