package com.pdxcycle9.repair_lst.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pdxcycle9.repair_lst.entities.User;

@Repository
public class UserDAO {
	
	 @PersistenceContext(unitName = "repair_lst")
	 private EntityManager em;
	
	 /**
	  * Function to find the userId 
	  * @param userName
	  * @param password
	  * @return the userId
	  */
	 @Transactional
     public int findUserId(String userName, String password) {
		 
		 User user = new User();
    	 Query query = em.createNamedQuery("findUserId"); 
    	 query.setParameter("userName", userName);
    	 query.setParameter("password", password);
    	 
    	 user = (User)query.getSingleResult();    	 
    	 return user.getId();
     }
}
