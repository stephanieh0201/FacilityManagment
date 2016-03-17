package fms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fms.model.facility.FacilityInterface;
import fms.model.manager.FacilityManager;

public class FacilityHibernateDAO {

	public void addFacility(FacilityInterface facility) {
		System.out.println("*************** Adding facility information in DB with ID ...  " + facility.getFacilityID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(facility);
		session.getTransaction().commit();
	}
	
	public void deleteFacility(FacilityInterface facility) {
		System.out.println("*************** Deleteing customer information in DB with ID ...  " + facility.getFacilityID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(facility);
		session.getTransaction().commit();
	}
	
	public FacilityInterface retrieveFacility(int facilityId) {
		try {
		System.out.println("*************** Searcing for facility information with ID ...  " + facilityId);
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		//System.out.println("*************** Hibernate session is created ..................\n" + session.toString());
		
		//Query getCustQuery = session.createQuery("From CustomerImpl ");
		Query getFacilityQuery = session.createQuery("From facility where facilityId=:facilityId");		
		getFacilityQuery.setInteger("facilityId", facilityId);
		
		System.out.println("*************** Retrieve Query is ....>>\n" + getFacilityQuery.toString()); 
		
		List facilities = getFacilityQuery.list();
		System.out.println("Getting Book Details using HQL. \n" + facilities);

		session.getTransaction().commit();
		return (FacilityInterface)facilities.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/*
	public Address retrieveCustomerAddress(String customerId) {
		try {
		System.out.println("*************** Searcing for customer address information with ID ...  " + customerId);
		Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	
        //Address billingAdd = (AddressImpl) session.load(AddressImpl.class, customerId);
        
        Query getAddresstQuery = session.createQuery("From AddressImpl where customerId=:customerId");		
        getAddresstQuery.setString("customerId", customerId);
		
		System.out.println("*************** Retrieve Query is ....>>\n" + getAddresstQuery.toString()); 
		
		List addresses = getAddresstQuery.list();
		System.out.println("Getting Book Details using HQL. \n" + addresses.get(0));
		
		System.out.println("*************** Retrieve Query is ....>>\n" + addresses.get(0).toString()); 
		
		session.getTransaction().commit();
		return (Address)addresses.get(0);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/
}
