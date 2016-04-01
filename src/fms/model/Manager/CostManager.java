package fms.model.manager;

import fms.dao.CostHibernateDAO;
import fms.model.maintenance.CostInterface;

public class CostManager {
	
	private CostHibernateDAO costDAO = new CostHibernateDAO();
	
	public void addCost(CostInterface cost) {
		try {
			costDAO.addCost(cost);
	    } catch (Exception se) {
	      System.err.println("CostManager: Threw a Exception adding cost.");
	      System.err.println(se.getMessage());
	    }
	}
	
	public CostInterface findCostById(int maintenanceId) {
		try {
			CostInterface cost = costDAO.retrieveCost(maintenanceId);
	    	return cost;
	    } catch (Exception se) {
	      System.err.println("CostManager: Threw a Exception retrieving cost.");
	      System.err.println(se.getMessage());
	    }
		return null;
	}
	
	public void deleteCost(CostInterface cost) {
		
		try {
			costDAO.deleteCost(cost);
	    } catch (Exception se) {
	      System.err.println("CostManager: Threw a Exception retrieving cost.");
	      System.err.println(se.getMessage());
	    }
	}
}
