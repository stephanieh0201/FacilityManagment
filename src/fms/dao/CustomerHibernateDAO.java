package fms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import fms.model.use.CustomerInterface;

public class CustomerHibernateDAO {
	public void addCustomer(CustomerInterface customer) {
		System.out.println("*************** Adding customer information in DB with ID ...  " + customer.getCustomerID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
	}
	
	
	public CustomerInterface retrieveCustomer(int customerId) {
		try {
		System.out.println("*************** Searching for customer information with ID ...  " + customerId);
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		
		
		//Query getCustQuery = session.createQuery("From CustomerImpl ");
		Query getCustomerQuery = session.createQuery("From Customer where customerId=:customerId");		
		getCustomerQuery.setInteger("customerId", customerId);
		
		System.out.println("*************** Retrieve Query is ....>>\n" + getCustomerQuery.toString()); 
		
		List customers = getCustomerQuery.list();
		System.out.println("Getting Customer Details using HQL. \n" + customers);

		session.getTransaction().commit();
		return (CustomerInterface)customers.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public CustomerInterface retrieveCustomerByLastName(String lastName) {
		try {
		System.out.println("*************** Searcing for customer information with last name ...  " + lastName);
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		
		
		//Query getCustQuery = session.createQuery("From CustomerImpl ");
		Query getCustomerQuery = session.createQuery("From Customer where lastName=:lastName");		
		getCustomerQuery.setString("lastName", lastName);
		
		System.out.println("*************** Retrieve Query is ....>>\n" + getCustomerQuery.toString()); 
		
		List customers = getCustomerQuery.list();
		System.out.println("Getting Customer Details using HQL. \n" + customers);

		session.getTransaction().commit();
		return (CustomerInterface)customers.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void deleteCustomer(CustomerInterface customer) {
		System.out.println("*************** Deleteing customer information in DB with ID ...  " + customer.getCustomerID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(customer);
		session.getTransaction().commit();
	}
}
