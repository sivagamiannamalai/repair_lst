package com.pdxcycle9.repair_lst.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pdxcycle9.repair_lst.entities.RepairType;

@Repository
public class RepairTypeDAO {

	@PersistenceContext(unitName = "repair_lst")
	private EntityManager em;

	public RepairType persistRepairType(RepairType repairType) {

		em.persist(repairType);

		return repairType;
	}

	@Transactional
	public List<RepairType> retrieveAllRepairTypes() {

		// System.out.println("Echo: Inside the repair facility DAO");

		Query query = em.createNamedQuery("findAllRepairTypes");

		return (List<RepairType>) query.getResultList();
	}
}
