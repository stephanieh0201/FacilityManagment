package fms.model.manager;

import fms.dao.ManagerHibernateDAO;
import fms.model.use.ManagerInterface;

public class ManagerManager {
	
	private ManagerHibernateDAO managerDAO = new ManagerHibernateDAO();
	
	
	public void addManager (ManagerInterface manager) {	
		try {
			managerDAO.addManager(manager);
	    } catch (Exception se) {
	      System.err.println("ManagerManager: Threw a Exception adding manager.");
	      System.err.println(se.getMessage());
	    }
	}

	public ManagerInterface findManagerById(int employeeId) {
		try {
			ManagerInterface manager = managerDAO.retrieveManager(employeeId);
	    	return manager;
	    } catch (Exception se) {
	      System.err.println("ManagerManager: Threw a Exception retrieving manager.");
	      System.err.println(se.getMessage());
	    }
		return null;
	}
	
	public ManagerInterface findCustomerByLastName(String lastName) {
		try {
			ManagerInterface manager = managerDAO.retrieveManagerByLastName(lastName);
	    	return manager;
	    } catch (Exception se) {
	      System.err.println("ManagerManager: Threw a Exception retrieving manager.");
	      System.err.println(se.getMessage());
	    }
		return null;
	}
	
	public void deleteManager(ManagerInterface manager) {	
		try {
			managerDAO.deleteManager(manager);
	    } catch (Exception se) {
	      System.err.println("ManagerManager: Threw a Exception retrieving manager.");
	      System.err.println(se.getMessage());
	    }
	}
}
