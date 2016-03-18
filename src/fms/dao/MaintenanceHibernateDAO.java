package fms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fms.model.facility.FacilityInterface;
import fms.model.maintenance.FacilityMaintenanceInterface;
import fms.model.manager.FacilityManager;

public class MaintenanceHibernateDAO {

	public void addMaintenance(FacilityMaintenanceInterface maintenance) {
		System.out.println("*************** Adding maintenance information in DB with ID ...  " + maintenance.getMaintenanceID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(maintenance);
		session.getTransaction().commit();
	}
	
	public void deleteMaintenance(FacilityMaintenanceInterface maintenance) {
		System.out.println("*************** Deleting maintenance information in DB with ID ...  " + maintenance.getMaintenanceID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(maintenance);
		session.getTransaction().commit();
	}
	
	public FacilityMaintenanceInterface retrieveMaintenance(int maintenanceID) {
		try {
		System.out.println("*************** Searcing for facility maintenance information with ID ...  " + maintenanceID);
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		//System.out.println("*************** Hibernate session is created ..................\n" + session.toString());
		
		//Query getCustQuery = session.createQuery("From CustomerImpl ");
		Query getMaintQuery = session.createQuery("From FacilityMaintenance where maintenanceID=:maintenanceID");		
		getMaintQuery.setInteger("maintenanceID", maintenanceID);
		
		System.out.println("*************** Retrieve Query is ....>>\n" + getMaintQuery.toString()); 
		
		List maintenances = getMaintQuery.list();
		System.out.println("Getting Book Details using HQL. \n" + maintenances);

		session.getTransaction().commit();
		return (FacilityMaintenanceInterface)maintenances.get(0);
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
