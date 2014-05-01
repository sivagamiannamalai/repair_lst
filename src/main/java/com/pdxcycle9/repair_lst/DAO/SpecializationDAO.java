package com.pdxcycle9.repair_lst.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pdxcycle9.repair_lst.entities.Specialization;
@Repository
public class SpecializationDAO {
	

	 
	
	@PersistenceContext(unitName = "repair_lst")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Specialization> retrieve() {
		
		//System.out.println("Echo: Inside the repair facility DAO");
		
		Query query = em.createNamedQuery("findAllSpecializations");

		

		return (List<Specialization>) query.getResultList();
	}
}
