package com.pdxcycle9.repair_lst.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pdxcycle9.repair_lst.entities.RepairFacility;

@Repository
//@Component
public class RepairFacilityDAO {
	@Autowired		
	SessionFactory sessionFactory;
	//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public RepairFacility persistRepairFacility(RepairFacility repairFacility) {
		
		
		Session session = sessionFactory.getCurrentSession();	
		session.persist(repairFacility);			
		return repairFacility;
	}
	
}
