package fms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fms.model.facility.DetailsInterface;

public class InspectionHibernateDAO {

	public void addDetails(DetailsInterface details) {
		System.out.println("*************** Adding details information in DB with ID ...  " + details.getDetailsID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(details);
		session.getTransaction().commit();
	}
	
	public void deleteDetails(DetailsInterface details) {
		System.out.println("*************** Deleteing customer information in DB with ID ...  " + details.getDetailsID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(details);
		session.getTransaction().commit();
	}
	
	public DetailsInterface retrieveDetails(int detailsId) {
		try {
		System.out.println("*************** Searcing for details information with ID ...  " + detailsId);
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	
		Query getDetailsQuery = session.createQuery("From Details where detailsId=:detailsId");		
		getDetailsQuery.setInteger("detailsId", detailsId);
		
		System.out.println("*************** Retrieve Query is ....>>\n" + getDetailsQuery.toString()); 
		
		List detailsList = getDetailsQuery.list();
		System.out.println("Getting Details Details using HQL. \n" + detailsList);

		session.getTransaction().commit();
		return (DetailsInterface)detailsList.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}


