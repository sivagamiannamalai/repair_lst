package com.pdxcycle9.repair_lst.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pdxcycle9.repair_lst.entities.RepairItem;

@Repository
public class RepairItemDAO {
	
	@PersistenceContext(unitName = "repair_lst")
	private EntityManager em;
	
	
	@Transactional
	public RepairItem retrieveRepairItemByID(int repairItemId) {		

		return em.find(RepairItem.class, repairItemId);

	}

}
