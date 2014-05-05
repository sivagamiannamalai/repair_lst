package com.pdxcycle9.repair_lst.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.pdxcycle9.repair_lst.entities.Address;



@Repository	
public class AddressDAO {	
	
	@PersistenceContext(unitName = "repair_lst")
	private EntityManager em;
	
    @Transactional
	public Address persistAddress(Address address) {
			
			em.persist(address);  			
			return address;
		}

		@Transactional
		public List<Address> retrieveAllAddresses() {
			
			Query query = em.createNamedQuery("findAllAdresses");			
			return (List<Address>) query.getResultList();
			
		}
		
		
		@Transactional
		public void deleteAddress(int addressId) {
			System.out.println("In the deleteAddress method");
			Address address = em.find(Address.class, addressId);
		    em.remove(address);		   
		}
		
		
}
