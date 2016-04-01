package fms.model.manager;

import fms.dao.CustomerHibernateDAO;
import fms.model.use.CustomerInterface;

public class CustomerManager {
	private CustomerHibernateDAO customerDAO = new CustomerHibernateDAO();
	
	
	public void addCustomer(CustomerInterface customer) {	
		try {
			customerDAO.addCustomer(customer);
	    } catch (Exception se) {
	      System.err.println("CustomerManager: Threw a Exception adding customer.");
	      System.err.println(se.getMessage());
	    }
	}

	public CustomerInterface findCustomerById(int customerId) {
		try {
			CustomerInterface customer = customerDAO.retrieveCustomer(customerId);
	    	return customer;
	    } catch (Exception se) {
	      System.err.println("CustomerManager: Threw a Exception retrieving customer.");
	      System.err.println(se.getMessage());
	    }
		return null;
	}
	
	public CustomerInterface findCustomerByLastName(String lastName) {
		try {
			CustomerInterface customer = customerDAO.retrieveCustomerByLastName(lastName);
	    	return customer;
	    } catch (Exception se) {
	      System.err.println("CustomerManager: Threw a Exception retrieving customer.");
	      System.err.println(se.getMessage());
	    }
		return null;
	}
	
	public void deleteCustomer(CustomerInterface customer) {	
		try {
			customerDAO.deleteCustomer(customer);
	    } catch (Exception se) {
	      System.err.println("CustomerManager: Threw a Exception retrieving customer.");
	      System.err.println(se.getMessage());
	    }
	}
}
