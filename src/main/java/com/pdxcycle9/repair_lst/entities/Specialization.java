package com.pdxcycle9.repair_lst.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "specialization")
public class Specialization {
	
	private List<Integer> specializationValues;

	public List<Integer> getSpecializationValues() {
		return specializationValues;
	}

	public void setSpecializationValues(List<Integer> specializationValues) {
		this.specializationValues = specializationValues;
	}
	
	

}
