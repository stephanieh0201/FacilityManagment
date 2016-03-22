package fms.model.manager;


import fms.dao.UseHibernateDAO;
import fms.model.use.FacilityUseInterface;

public class UseManager {
//	private UseDAO useDAO = new UseDAO();
	private FacilityUseInterface facilityUse;
	
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
	      System.err.println("MaintenanceManager: Threw a Exception retrieving iuse.");
	      System.err.println(se.getMessage());
	    }
}
//	//search maintenance by requestID from the database
//	public FacilityUse findUseById(int customerID) {
//			
//		try {
//			FacilityUse use = UseDAO.getCustomerID(customerID);
//	    	return use;
//	    } catch (Exception se) {
//	      System.err.println("UseManager: Threw a Exception retrieving FacilityUse.");
//	      System.err.println(se.getMessage());
//	    }
//		return null;
//	}
//	
//	//Insert a new facility into the database
//	public void addUse(FacilityUse use) {
//		
//		try {
//			UseDAO.addUseRequest(use);
//	    } catch (Exception se) {
//	      System.err.println("UseManager: Threw a Exception adding FacilityUse.");
//	      System.err.println(se.getMessage());
//	    }
//	}
//	

	public FacilityUseInterface getFacilityUse() {
		return facilityUse;
	}

	public void setFacilityUse(FacilityUseInterface facilityUse) {
		this.facilityUse = facilityUse;
	}
}

