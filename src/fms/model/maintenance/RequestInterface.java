package fms.model.maintenance;

import java.util.Date;

import fms.model.facility.Facility;

public interface RequestInterface {
	
	public String toString();
	public int getRequestID();
	public void setRequestID(int requestID);
	public Facility getFacility();
	public void setFacility(Facility facility);
	public Date getRequestDate();
	public void setRequestDate(Date requestDate);
	public Date getCompleteDate();
	public void setCompleteDate(Date completeDate);
	public Problem getProblem();
	public void setProblem(Problem problem);
	public MaintenanceSchedule getMaintenanceSchedule();
	public void setMaintenanceSchedule(MaintenanceSchedule maintenanceSchedule);
	public int getProblemID();
	public void setProblemID(int problemID);

}
