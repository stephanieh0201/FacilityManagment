package fms.model.manager;

import fms.dao.MaintenanceHibernateDAO;
import fms.model.maintenance.FacilityMaintenanceInterface;

public class MaintenanceManager {

	private MaintenanceHibernateDAO maintDAO = new MaintenanceHibernateDAO();
	
	public void addMaintenance(FacilityMaintenanceInterface maint) {
		
		try {
			maintDAO.addMaintenance(maint);
	    } catch (Exception se) {
	      System.err.println("MaintenanceManager: Threw a Exception adding maintenance.");
	      System.err.println(se.getMessage());
	    }
	}
		
	public FacilityMaintenanceInterface findMaintenanceById(int maintenanceID) {
			
			try {
				FacilityMaintenanceInterface maintenance = maintDAO.retrieveMaintenance(maintenanceID);
		    	return maintenance;
		    } catch (Exception se) {
		      System.err.println("MaintenanceManager: Threw a Exception retrieving maintenance.");
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
}

