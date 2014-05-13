package com.pdxcycle9.repair_lst.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pdxcycle9.repair_lst.entities.Part;
import com.pdxcycle9.repair_lst.entities.User;
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

	@Transactional
	public List<Vehicle> retrieveVehicleByUserID(int userId) {
		List<Vehicle> listOfUserVehicles = new ArrayList<Vehicle>();
		Query query = em.createNamedQuery("findAllVehiclesByUserId");
		query.setParameter("userId", userId);
		//listOfUserVehicles = (List<Vehicle>)query.getSingleResult(); 
		listOfUserVehicles = query.getResultList();
		return listOfUserVehicles;
		//return (List<Vehicle>) em.find(Vehicle.class, userId);

	}

}
