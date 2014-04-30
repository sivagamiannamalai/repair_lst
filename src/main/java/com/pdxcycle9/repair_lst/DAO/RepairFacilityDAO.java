package com.pdxcycle9.repair_lst.DAO;


import java.util.Collection;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.pdxcycle9.repair_lst.entities.RepairFacility;

@Repository
public class RepairFacilityDAO {
	
	@PersistenceContext(unitName = "repair_lst")
	private EntityManager em;
	
	public RepairFacility persistRepairFacility(RepairFacility repairFacility) {		
		
		em.persist(repairFacility);			
		return repairFacility;
	}
	
	public Collection<RepairFacility> retrieveRepairFacility() {		
		Query query = (Query) em.createQuery("SELECT * FROM lst_repairtracker.repair_facility");
		return (Collection<RepairFacility>) query.getResultList();
		  }
	}
	

