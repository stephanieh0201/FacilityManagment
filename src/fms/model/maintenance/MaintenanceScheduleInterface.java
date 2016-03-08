package fms.model.maintenance;

import java.util.Date;

import fms.model.facility.Facility;

public interface  MaintenanceScheduleInterface {

	public Facility getFacility();
	public void setFacility(Facility facility);
	public Date getReserveDate();
	public void setReserveDate(Date reserveDate);
	public boolean getStatus();
	public void setStatus(Boolean status);
	
}

