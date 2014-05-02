package com.pdxcycle9.repair_lst.DAO;

import java.util.ArrayList;
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
	public List<RepairFacility> retrieveAllRepairFacility() {

		Query query = em.createNamedQuery("findAllRepairFacilities");
		List<RepairFacility> results = new ArrayList <RepairFacility>() ;
		
		results = (List<RepairFacility>) query.getResultList();
		
		System.out.println(results);
		
		return results;
	}
	
	/**
	 * update the repair facility
	 */
	public RepairFacility updateRepairFacility(RepairFacility repairFacility) {		
		
		em.persist(repairFacility);
		//em.refresh(repairFacility);
		
		return repairFacility;
		
	}
	
}
