package fms.model.maintenance;

import java.util.Date;

public interface IFacilityMaintenance {
	public void makeFacilityMaintRequest(Request request); 
	public void scheduleMaintenance(Date date);
	public int calcMaintenanceCostForFacility(Request request);
	public int calcProblemRateForFacility();
	public int calcDownTimeForFacility(Request request);
	public void listMaintRequests();
	public void listMaintenance(); 
	public void listFacilityProblems();
}
