package fms.model.maintenance;

import java.util.Date;

import fms.model.facility.Facility;
import fms.model.facility.FacilityInterface;

public interface RequestInterface {
	
	public String toString();
	public int getRequestID();
	public void setRequestID(int requestID);
	public FacilityInterface getFacility();
	public void setFacility(FacilityInterface facility);
	public Date getRequestDate();
	public void setRequestDate(Date requestDate);
	public Date getCompleteDate();
	public void setCompleteDate(Date completeDate);
	public ProblemInterface getProblem();
	public void setProblem(ProblemInterface problem);
	public MaintenanceScheduleInterface getMaintenanceSchedule();
	public void setMaintenanceSchedule(MaintenanceScheduleInterface maintenanceSchedule);
	public int getProblemID();
	public void setProblemID(int problemID);
	public int getMaintenanceID();
	public void setMaintenanceID(int maintenanceID);

}
