package com.pdxcycle9.repair_lst.DAO;


import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.pdxcycle9.repair_lst.entities.RepairFacility;

@Repository
public class RepairFacilityDAO {
	
	@PersistenceContext(unitName = "repair_lst")
	private EntityManager em;
	
	public RepairFacility persistRepairFacility(RepairFacility repairFacility) {		
		
		em.persist(repairFacility);			
		return repairFacility;
	}
	
	public List<RepairFacility> retrieveRepairFacility() {	
		List<RepairFacility> query = em.createQuery("SELECT e FROM lst_repairtracker.repair_facility e", RepairFacility.class).getResultList();
				return query;
		  }
	}
	

