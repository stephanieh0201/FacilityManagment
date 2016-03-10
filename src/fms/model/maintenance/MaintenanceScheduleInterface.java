package fms.model.maintenance;

import java.util.Date;

import fms.model.facility.Facility;
import fms.model.facility.FacilityInterface;

public interface  MaintenanceScheduleInterface {

	public FacilityInterface getFacility();
	public void setFacility(FacilityInterface facility);
	public Date getReserveDate();
	public void setReserveDate(Date reserveDate);
	public boolean getStatus();
	public void setStatus(Boolean status);

	
}

