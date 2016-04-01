package fms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


import fms.model.use.ManagerInterface;

public class ManagerHibernateDAO {
	
	public void addManager(ManagerInterface manager) {
		System.out.println("*************** Adding manager information in DB with ID ...  " + manager.getEmployeeID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(manager);
		session.getTransaction().commit();
	}
	
	
	public ManagerInterface retrieveManager(int employeeId) {
		try {
		System.out.println("*************** Searcing for manager information with ID ...  " + employeeId);
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query getManagerQuery = session.createQuery("From Manager where employeeId=:employeeId");		
		getManagerQuery.setInteger("employeeId", employeeId);
		
		System.out.println("*************** Retrieve Query is ....>>\n" + getManagerQuery.toString()); 
		
		List managers = getManagerQuery.list();
		System.out.println("Getting Manager Details using HQL. \n" + managers);

		session.getTransaction().commit();
		return (ManagerInterface) managers.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ManagerInterface retrieveManagerByLastName(String lastName) {
		try {
		System.out.println("*************** Searching for manager information with last name ...  " + lastName);
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		
		
		//Query getCustQuery = session.createQuery("From CustomerImpl ");
		Query getManagerQuery = session.createQuery("From Manager where lastName=:lastName");		
		getManagerQuery.setString("lastName", lastName);
		
		System.out.println("*************** Retrieve Query is ....>>\n" + getManagerQuery.toString()); 
		
		List managers = getManagerQuery.list();
		System.out.println("Getting Manager Details using HQL. \n" + managers);

		session.getTransaction().commit();
		return (ManagerInterface)managers.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void deleteManager(ManagerInterface manager) {
		System.out.println("*************** Deleteing manager information in DB with ID ...  " + manager.getEmployeeID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(manager);
		session.getTransaction().commit();
	}

}
