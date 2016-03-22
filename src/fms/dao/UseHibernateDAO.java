package fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.Query;
import org.hibernate.Session;

import fms.model.maintenance.FacilityMaintenanceInterface;
import fms.model.use.Customer;
import fms.model.use.FacilityUse;
import fms.model.use.FacilityUseInterface;


public class UseHibernateDAO {

	public void addUse(FacilityUseInterface use) {
		System.out.println("*************** Adding maintenance information in DB with ID ...  " + use.getUseID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(use);
		session.getTransaction().commit();
	}
	
	public void deleteUse(FacilityUseInterface use) {
		System.out.println("*************** Deleting maintenance information in DB with ID ...  " + use.getUseID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(use);
		session.getTransaction().commit();
	}
	
	public FacilityUseInterface retrieveUse(int useID) {
		try {
		System.out.println("*************** Searcing for facility use information with ID ...  " + useID);
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		//System.out.println("*************** Hibernate session is created ..................\n" + session.toString());
		
		//Query getCustQuery = session.createQuery("From CustomerImpl ");
		Query getUseQuery = session.createQuery("From FacilityUse where useID=:useID");		
		getUseQuery.setInteger("useID", useID);
		
		System.out.println("*************** Retrieve Query is ....>>\n" + getUseQuery.toString()); 
		
		List uses = getUseQuery.list();
		System.out.println("Getting Book Details using HQL. \n" + uses);

		session.getTransaction().commit();
		return (FacilityUseInterface)uses.get(0);
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
