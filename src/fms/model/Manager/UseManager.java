package fms.model.manager;


import fms.dao.UseHibernateDAO;
import fms.model.use.FacilityUseInterface;

public class UseManager {
	
	private UseHibernateDAO useDAO = new UseHibernateDAO();
	
	public void addUse(FacilityUseInterface use) {
		
		try {
			useDAO.addUse(use);
	    } catch (Exception se) {
	      System.err.println("UseManager: Threw a Exception adding facility use.");
	      System.err.println(se.getMessage());
	    }
	}
		
	public FacilityUseInterface findUseById(int useID) {
			
			try {
				FacilityUseInterface maintenance = useDAO.retrieveUse(useID);
		    	return maintenance;
		    } catch (Exception se) {
		      System.err.println("UseManager: Threw a Exception retrieving use.");
		      System.err.println(se.getMessage());
		    }
			return null;
		}
		
	public void deleteUse(FacilityUseInterface use) {
		
		try {
			useDAO.deleteUse(use);
	    } catch (Exception se) {
	      System.err.println("UseManager: Threw a Exception retrieving use.");
	      System.err.println(se.getMessage());
	    }
	}
}

