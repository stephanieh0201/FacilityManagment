package fms.model.manager;

import fms.dao.DetailsHibernateDAO;
import fms.model.facility.DetailsInterface;

public class DetailsManager {
	
	private DetailsHibernateDAO detailsDAO = new DetailsHibernateDAO();
	
	public void addDetails(DetailsInterface details) {
		try {
			detailsDAO.addDetails(details);
	    } catch (Exception se) {
	      System.err.println("DetailsManager: Threw a Exception adding details.");
	      System.err.println(se.getMessage());
	    }
	}
	
	public DetailsInterface findDetailsById(int facilityId) {
		try {
			DetailsInterface details = detailsDAO.retrieveDetails(facilityId);
	    	return details;
	    } catch (Exception se) {
	      System.err.println("DetailsManager: Threw a Exception retrieving details.");
	      System.err.println(se.getMessage());
	    }
		return null;
	}
	
	public void deleteDetails(DetailsInterface details) {
		
		try {
			detailsDAO.deleteDetails(details);
	    } catch (Exception se) {
	      System.err.println("DetailsManager: Threw a Exception retrieving details.");
	      System.err.println(se.getMessage());
	    }
	}
}