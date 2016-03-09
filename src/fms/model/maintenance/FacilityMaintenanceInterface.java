package fms.model.maintenance;

import java.util.Date;
import java.util.List;

public interface FacilityMaintenanceInterface {
	public Request makeFacilityMaintRequest(Request request); 
	public Request scheduleMaintenance(Date requestDate, Date completeDate);
	public int calcMaintenanceCostForFacility(Request request);
	public int calcProblemRateForFacility(Problem problem);
	public int calcDownTimeForFacility(Request request);
	public List<Request> listMaintRequests();
	public String listMaintenance(); 
	public String listFacilityProblems();
}
