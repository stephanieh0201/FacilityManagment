package fms.model.manager;

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
	      System.err.println("MaintenanceManager: Threw a Exception retrieving FacilityMaintenance.");
	      System.err.println(se.getMessage());
	    }
		return null;
	}
	
	//Insert a new facility into the database
	public void addMaint(FacilityMaintenance maint) {
		
		try {
			MaintenanceDAO.addMaintRequest(maint);
	    } catch (Exception se) {
	      System.err.println("MaintenanceManager: Threw a Exception adding FacilityMaintenance.");
	      System.err.println(se.getMessage());
	    }
	}
	
}

