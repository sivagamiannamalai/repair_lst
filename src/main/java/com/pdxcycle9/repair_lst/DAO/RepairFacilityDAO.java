package com.pdxcycle9.repair_lst.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pdxcycle9.repair_lst.entities.RepairFacility;

@Repository
public class RepairFacilityDAO {

	@PersistenceContext(unitName = "repair_lst")
	private EntityManager em;

	
	public RepairFacility persistRepairFacility(RepairFacility repairFacility) {		
		
		em.persist(repairFacility);	
		
		return repairFacility;
		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<RepairFacility> retrieveRepairFacility() {
		//System.out.println("Echo: Inside the repair facility DAO");
		Query query = em.createNamedQuery("findAllRepairFacilities");
		

		return (List<RepairFacility>) query.getResultList();
	}
	
	/**
	 * update the repair facility
	 */
	public RepairFacility updateRepairFacility(RepairFacility repairFacility) {		
		
		em.persist(repairFacility);
		
		return repairFacility;
		
	}
	
}
