package com.pdxcycle9.repair_lst.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.pdxcycle9.repair_lst.entities.Address;

@Repository	
public class AddressDAO {	
	
	@PersistenceContext(unitName = "repair_lst")
	private EntityManager em;
	
		//@Resource(name="sessionFactory")
		//private	SessionFactory sessionFactory;
	
//	@Autowired
//	HibernateUtil hibernateUtil;

		public Address persistAddress(Address address) {
			
			em.persist(address);
			
			return address;
		}
//			try {
//			System.out.println("Hello");
//			//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//			//System.out.println(session);
//			//System.out.println("Address1 is " + address);
//			session.beginTransaction();
//
//			
//			
//			session.persist(address);
//			
//			//session.flush();
//			
//			System.out.println("Address2 is " + address);
//			session.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return address;
//		}

//	public SessionFactory getSessionFactory() {
//		return new AnnotationConfiguration().configure().buildSessionFactory();
//	}
//
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory =  new AnnotationConfiguration().configure().buildSessionFactory();
//	}
}
