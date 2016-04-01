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
		System.out.println("*************** Searching for facility maintenance information with ID ...  " + maintenanceID);
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Query getMaintQuery = session.createQuery("From FacilityMaintenance where maintenanceID=:maintenanceID");		
		getMaintQuery.setInteger("maintenanceID", maintenanceID);
		
		System.out.println("*************** Retrieve Query is ....>>\n" + getMaintQuery.toString()); 
		
		List maintenances = getMaintQuery.list();
		System.out.println("Getting Maintenance Details using HQL. \n" + maintenances);

		session.getTransaction().commit();
		return (FacilityMaintenanceInterface)maintenances.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
