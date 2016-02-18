package fms.model.maintenance;

import java.util.Date;
import java.util.List;

public interface IFacilityMaintenance {
	public Request makeFacilityMaintRequest(Request request); 
	public String scheduleMaintenance(String date);
	public int calcMaintenanceCostForFacility(Request request);
	public int calcProblemRateForFacility();
	public int calcDownTimeForFacility(Request request);
	public List<Request> listMaintRequests();
	public String listMaintenance(); 
	public String listFacilityProblems();
}
