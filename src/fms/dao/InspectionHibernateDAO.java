package fms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fms.model.use.InspectionInterface;

public class InspectionHibernateDAO {

	public void addInspection(InspectionInterface inspection) {
		System.out.println("*************** Adding inspection information in DB with ID ...  " + inspection.getInspectionID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(inspection);
		session.getTransaction().commit();
	}
	
	public void deleteInspection(InspectionInterface inspection) {
		System.out.println("*************** Deleteing inspection information in DB with ID ...  " + inspection.getInspectionID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(inspection);
		session.getTransaction().commit();
	}
	
	public InspectionInterface retrieveInspection(int inspectionId) {
		try {
		System.out.println("*************** Searching for inspection information with ID ...  " + inspectionId);
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	
		Query getInspectionQuery = session.createQuery("From Inspection where inspectionId=:inspectionId");		
		getInspectionQuery.setInteger("inspectionId", inspectionId);
		
		System.out.println("*************** Retrieve Query is ....>>\n" + getInspectionQuery.toString()); 
		
		List inspectionList = getInspectionQuery.list();
		System.out.println("Getting Inspection Inspection using HQL. \n" + inspectionList);

		session.getTransaction().commit();
		return (InspectionInterface)inspectionList.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}


