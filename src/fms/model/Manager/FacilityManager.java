package fms.model.manager;


import fms.dal.FacilityDAO;
import fms.model.facility.Facility;

public class FacilityManager {
	private FacilityDAO facilityDAO = new FacilityDAO();
	
	//search facility by ID from the database
	public Facility findFacilityById(int facilityID) {
			
		try {
			Facility facility = FacilityDAO.getFacilityID(facilityID);
	    	return facility;
	    } catch (Exception se) {
	      System.err.println("FacilityManager: Threw a Exception retrieving facility.");
	      System.err.println(se.getMessage());
	    }
		return null;
	}
	
	//Insert a new facility into the database
	public void addFacility(Facility facility) {
		
		try {
			FacilityDAO.addFacility(facility);
	    } catch (Exception se) {
	      System.err.println("FacilityManager: Threw a Exception adding facility.");
	      System.err.println(se.getMessage());
	    }
	}
	
}

