package fms.model.manager;

import fms.dal.MaintenanceDAO;
import fms.dal.UseDAO;
import fms.model.maintenance.FacilityMaintenance;
import fms.model.use.FacilityUse;
import fms.model.use.FacilityUseInterface;

public class UseManager {
//	private UseDAO useDAO = new UseDAO();
	private FacilityUseInterface facilityUse;
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

