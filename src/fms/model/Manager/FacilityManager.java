package fms.model.manager;


import fms.dao.FacilityHibernateDAO;
import fms.model.facility.Facility;
import fms.model.facility.FacilityInterface;

public class FacilityManager {
	private FacilityHibernateDAO facilityDAO = new FacilityHibernateDAO();
	
	public void addFacility(FacilityInterface facility) {
		
		try {
			facilityDAO.addFacility(facility);
	    } catch (Exception se) {
	      System.err.println("FacilityManager: Threw a Exception adding facility.");
	      System.err.println(se.getMessage());
	    }
	}
	public FacilityInterface findFacilityById(int facilityId) {
		
		try {
			FacilityInterface facility = facilityDAO.retrieveFacility(facilityId);
	    	return facility;
	    } catch (Exception se) {
	      System.err.println("CustomerService: Threw a Exception retrieving facility.");
	      System.err.println(se.getMessage());
	    }
		return null;
	}
	
	public void deleteFacility(FacilityInterface facility) {
		
		try {
			facilityDAO.deleteFacility(facility);
	    } catch (Exception se) {
	      System.err.println("FacilityManager: Threw a Exception retrieving facility.");
	      System.err.println(se.getMessage());
	    }
}

	//private FacilityInterface facility;
/*
	public FacilityInterface getFacility() {
		return facility;
	}

	public void setFacility(FacilityInterface facility) {
		this.facility = facility;
	}*/
	
	
	//search facility by ID from the database
//	public FacilityInterface setFacility(FacilityInterface facility) {
//			
//		try {
//			Facility facility = FacilityDAO.getFacilityID(facilityID);
//	    	return facility;
//	    } catch (Exception se) {
//	      System.err.println("FacilityManager: Threw a Exception retrieving facility.");
//	      System.err.println(se.getMessage());
//	    }
//		return null;
//	}
//	
	//Insert a new facility into the database
//	public void addFacility(Facility facility) {
//		
//		try {
//			FacilityDAO.addFacility(facility);
//	    } catch (Exception se) {
//	      System.err.println("FacilityManager: Threw a Exception adding facility.");
//	      System.err.println(se.getMessage());
//	    }
//	}
//	
}

