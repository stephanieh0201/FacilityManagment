package fms.model.maintenance;

import java.util.Date;
import java.util.List;

import fms.model.facility.FacilityInterface;

public interface FacilityMaintenanceInterface {
	public RequestInterface makeFacilityMaintRequest(RequestInterface request); 
	public RequestInterface scheduleMaintenance(Date requestDate, Date completeDate);
	public int calcMaintenanceCostForFacility(RequestInterface request);
	public int calcProblemRateForFacility(ProblemInterface problem);
	public int calcDownTimeForFacility(RequestInterface request);
	public List<RequestInterface> listMaintRequests();
	public String listMaintenance(); 
	public String listFacilityProblems();
	public int getFacilityID();
	public void setFacilityID(int facilityID);
	public CostInterface getCost();
	public void setCost(CostInterface cost);
	public FacilityInterface getFacility();
	public void setFacility(FacilityInterface facility);
	public List<RequestInterface> getListRequests();
	public void setListRequests(List<RequestInterface> listRequests);
	public int getMaintenanceID();
	public void setMaintenanceID(int maintenanceID);
	public void addRequest(RequestInterface request);
}
