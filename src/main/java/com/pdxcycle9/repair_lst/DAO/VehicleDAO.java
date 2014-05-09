package com.pdxcycle9.repair_lst.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pdxcycle9.repair_lst.entities.Vehicle;

@Repository	
public class VehicleDAO {

	@PersistenceContext(unitName = "repair_lst")
	private EntityManager em;
	
@Transactional
		public Vehicle persistVehicle(Vehicle vehicle) {
			
			em.persist(vehicle);
			
			return vehicle;
		}
	
}
