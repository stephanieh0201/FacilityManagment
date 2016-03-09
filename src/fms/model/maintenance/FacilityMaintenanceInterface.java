package fms.model.maintenance;

import java.util.Date;
import java.util.List;

public interface FacilityMaintenanceInterface {


	public RequestInterface makeFacilityMaintRequest(RequestInterface request); 
	public RequestInterface scheduleMaintenance(Date requestDate, Date completeDate);
	public int calcMaintenanceCostForFacility(RequestInterface request);
	public int calcProblemRateForFacility(Problem problem);
	public int calcDownTimeForFacility(Request request);
	public List<RequestInterface> listMaintRequests();
	public String listMaintenance(); 
	public String listFacilityProblems();
}
