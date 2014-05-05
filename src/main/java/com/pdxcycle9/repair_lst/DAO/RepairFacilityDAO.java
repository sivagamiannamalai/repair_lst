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
		
		try {
			em.persist(repairFacility);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
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
		
		try{
		System.out.println("I'm updating what now?");
		em.merge(repairFacility);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return repairFacility;
	}
	
	@Transactional
	public RepairFacility retrieveRepairFacilityByID(int repairFacilityId) {		


		RepairFacility result = new RepairFacility();
		
		Query query = em.createNamedQuery("findRepairFacilityById");
		query.setParameter("id", repairFacilityId);
		
		result = (RepairFacility) query.getSingleResult();
		return result;
		
	}
	
	
}
