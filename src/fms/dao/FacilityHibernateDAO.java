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
		System.out.println("*************** Deleteing facility information in DB with ID ...  " + facility.getFacilityID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(facility);
		session.getTransaction().commit();
	}
	
	public FacilityInterface retrieveFacility(int facilityId) {
		try {
		System.out.println("*************** Searching for facility information with ID ...  " + facilityId);
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
			
		Query getFacilityQuery = session.createQuery("From Facility where facilityId=:facilityId");		
		getFacilityQuery.setInteger("facilityId", facilityId);
		
		System.out.println("*************** Retrieve Query is ....>>\n" + getFacilityQuery.toString()); 
		
		List facilities = getFacilityQuery.list();
		System.out.println("Getting Facility Details using HQL. \n" + facilities);

		session.getTransaction().commit();
		return (FacilityInterface)facilities.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
