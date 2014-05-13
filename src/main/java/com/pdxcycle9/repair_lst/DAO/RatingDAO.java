package com.pdxcycle9.repair_lst.DAO;

import java.math.BigDecimal;
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

	@PersistenceContext(unitName = "repair_lst")
	private EntityManager em;

	@Transactional
	public RepairFacility getRepairFacilityRating(String repairFacilityNameToSearch) {

		RepairFacility foundRepairFacility = new RepairFacility();
		Double averageRating = 0.00;
		Query query = em.createNamedQuery("findRepairFacilityByName");
		query.setParameter("name", repairFacilityNameToSearch);

		foundRepairFacility = (RepairFacility) query.getSingleResult();

		String findTheRating = "SELECT lst_repairtracker.getaverageratingbyname('"+ foundRepairFacility.getId() + "')";
		Query getTheRating = em.createNativeQuery(findTheRating);
		System.out.println("Set the query passed");
		averageRating = (Double) getTheRating.getSingleResult();
		foundRepairFacility.setRating(averageRating);
		return foundRepairFacility;

	}

}
