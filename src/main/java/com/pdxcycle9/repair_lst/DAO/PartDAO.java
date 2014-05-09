package com.pdxcycle9.repair_lst.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class PartDAO {
	
	
	@PersistenceContext(unitName = "repair_lst")
	private EntityManager em;
	
	public void persistPartsToRepairItem() {
		
		
		
	}
	

}
