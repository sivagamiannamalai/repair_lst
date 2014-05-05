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

	@Transactional
	public RepairFacility persistRepairFacility(RepairFacility repairFacility) {		
		
		 em.persist(repairFacility);			 
		 return repairFacility;		
	}
	
	

	@SuppressWarnings("unchecked")
	@Transactional
	public List<RepairFacility> retrieveAllRepairFacility() {

		List<RepairFacility> results = new ArrayList <RepairFacility>() ;
		
		try{
		
			Query query = em.createNamedQuery("findAllRepairFacilities");
		
			results = (List<RepairFacility>) query.getResultList();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return results;
	}
	
	/**
	 * update the repair facility
	 */
	@Transactional
	public RepairFacility updateRepairFacility(RepairFacility repairFacility) {		
		
		System.out.println("I'm updating what now?");
		em.merge(repairFacility);

		return repairFacility;
	}
	
	public RepairFacility retrieveRepairFacilityByID(RepairFacility repairFacility) {		
		
		em.merge(repairFacility);
		
		return repairFacility;
		
	}
	
	
}
