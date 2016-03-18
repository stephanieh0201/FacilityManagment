package fms.model.manager;

import fms.dao.FacilityDAO;
import fms.dao.FacilityHibernateDAO;
import fms.dao.MaintenanceDAO;
import fms.dao.MaintenanceHibernateDAO;
import fms.model.facility.Facility;
import fms.model.facility.FacilityInterface;
import fms.model.maintenance.FacilityMaintenance;
import fms.model.maintenance.FacilityMaintenanceInterface;

public class MaintenanceManager {
	//private MaintenanceDAO maintDAO = new MaintenanceDAO();
	private MaintenanceHibernateDAO maintDAO = new MaintenanceHibernateDAO();
	
	public void addMaintenance(FacilityMaintenanceInterface maint) {
		
		try {
			maintDAO.addMaintenance(maint);
	    } catch (Exception se) {
	      System.err.println("FacilityManager: Threw a Exception adding facility.");
	      System.err.println(se.getMessage());
	    }
	}
		
	public FacilityMaintenanceInterface findMaintenanceById(int maintenanceID) {
			
			try {
				FacilityMaintenanceInterface maintenance = maintDAO.retrieveMaintenance(maintenanceID);
		    	return maintenance;
		    } catch (Exception se) {
		      System.err.println("CustomerService: Threw a Exception retrieving facility.");
		      System.err.println(se.getMessage());
		    }
			return null;
		}
		
	public void deleteMaintenance(FacilityMaintenanceInterface maintenance) {
		
		try {
			maintDAO.deleteMaintenance(maintenance);
	    } catch (Exception se) {
	      System.err.println("MaintenanceManager: Threw a Exception retrieving maintenance.");
	      System.err.println(se.getMessage());
	    }
}

//	//search maintenance by requestID from the database
//	public FacilityMaintenance findMaintById(int requestID) {
//			
//		try {
//			FacilityMaintenance maint = MaintenanceDAO.getRequestID(requestID);
//	    	return maint;
//	    } catch (Exception se) {
//	      System.err.println("MaintenanceManager: Threw a Exception retrieving FacilityMaintenance.");
//	      System.err.println(se.getMessage());
//	    }
//		return null;
//	}
	
//	//Insert a new facility into the database
//	public void addMaint(FacilityMaintenance maint) {
//		
//		try {
//			MaintenanceDAO.addMaintRequest(maint);
//	    } catch (Exception se) {
//	      System.err.println("MaintenanceManager: Threw a Exception adding FacilityMaintenance.");
//	      System.err.println(se.getMessage());
//	    }
//	}
/*
	public FacilityMaintenanceInterface getFacilityMaintenance() {
		return facilityMaintenance;
	}

	public void setFacilityMaintenance(FacilityMaintenanceInterface facilityMaintenance) {
		this.facilityMaintenance = facilityMaintenance;
	}
*/	
}

