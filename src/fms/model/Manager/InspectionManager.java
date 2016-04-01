package fms.model.manager;

import fms.dao.InspectionHibernateDAO;
import fms.model.use.InspectionInterface;

public class InspectionManager {

	private InspectionHibernateDAO inspectionDAO = new InspectionHibernateDAO();
	
	public void addInspection(InspectionInterface inspection) {
		try {
			inspectionDAO.addInspection(inspection);
	    } catch (Exception se) {
	      System.err.println("InspectionManager: Threw a Exception adding inspection.");
	      System.err.println(se.getMessage());
	    }
	}
	
	public InspectionInterface findInspectionById(int inspectionId) {
		try {
			InspectionInterface inspection = inspectionDAO.retrieveInspection(inspectionId);
	    	return inspection;
	    } catch (Exception se) {
	      System.err.println("InspectionManager: Threw a Exception retrieving inspection.");
	      System.err.println(se.getMessage());
	    }
		return null;
	}
	
	public void deleteInspection(InspectionInterface inspection) {
		
		try {
			inspectionDAO.deleteInspection(inspection);
	    } catch (Exception se) {
	      System.err.println("InspectionManager: Threw a Exception retrieving inspection.");
	      System.err.println(se.getMessage());
	    }
	}
}

