package com.pdxcycle9.repair_lst.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pdxcycle9.repair_lst.entities.RepairFacility;
import com.pdxcycle9.repair_lst.entities.RepairItem;

@Repository
public class RatingDAO {
	
public List<RepairItem> getRepairFacilityId(RepairFacility repairFacility) {			
	
	List<RepairItem> results = null;
	
	Query query = em.createNamedQuery("GetRepairItemsByName");
	
	query.setParameter("name",repairFacility.getName());
	results = (List<RepairItem>) query.getResultList();
	
	return results;
	}	

}
