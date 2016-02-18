package fms.model.Manager;

import fms.dal.FacilityDAO;
import fms.dal.MaintenanceDAO;
import fms.model.facility.Facility;
import fms.model.maintenance.FacilityMaintenance;

public class MaintenanceManager {
	private MaintenanceDAO maintDAO = new MaintenanceDAO();
	
	//search maintenance by requestID from the database
	public FacilityMaintenance findMaintById(int requestID) {
			
		try {
			FacilityMaintenance maint = MaintenanceDAO.getRequestID(requestID);
	    	return maint;
	    } catch (Exception se) {
	      System.err.println("FacilityManager: Threw a Exception retrieving facility.");
	      System.err.println(se.getMessage());
	    }
		return null;
	}
	
	//Insert a new facility into the database
	public void addMaint(FacilityMaintenance maint) {
		
		try {
			MaintenanceDAO.addMaintRequest(maint);
	    } catch (Exception se) {
	      System.err.println("CustomerService: Threw a Exception retrieving customer.");
	      System.err.println(se.getMessage());
	    }
	}
	
}

