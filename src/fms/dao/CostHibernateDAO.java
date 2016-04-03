package fms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fms.model.maintenance.CostInterface;

public class CostHibernateDAO {
	
	public void addCost(CostInterface cost) {
		System.out.println("*************** Adding cost information in DB with ID ...  " + cost.getMaintenanceID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(cost);
		session.getTransaction().commit();
	}
	
	public void deleteCost(CostInterface cost) {
		System.out.println("*************** Deleteing cost information in DB with ID ...  " + cost.getMaintenanceID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(cost);
		session.getTransaction().commit();
	}
	
	public CostInterface retrieveCost(int maintenanceId) {
		try {
		System.out.println("*************** Searching for cost information with ID ...  " + maintenanceId);
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	
		Query getCostQuery = session.createQuery("From Cost where maintenanceId=:maintenanceId");		
		getCostQuery.setInteger("maintenanceId", maintenanceId);
		
		System.out.println("*************** Retrieve Query is ....>>\n" + getCostQuery.toString()); 
		
		List costs = getCostQuery.list();
		System.out.println("Getting Cost Details using HQL. \n" + costs);

		session.getTransaction().commit();
		return (CostInterface)costs.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
