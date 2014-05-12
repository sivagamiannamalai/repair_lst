package com.pdxcycle9.repair_lst.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pdxcycle9.repair_lst.entities.Part;

@Repository
public class PartDAO {

	@PersistenceContext(unitName = "repair_lst")
	private EntityManager em;

	public void persistPartsToRepairItem() {

	}

	@Transactional
	public List<Part> retrieveAllParts() {

		// System.out.println("Echo: Inside the repair facility DAO");

		Query query = em.createNamedQuery("retrieveAllParts");

		return (List<Part>) query.getResultList();

	}
}
