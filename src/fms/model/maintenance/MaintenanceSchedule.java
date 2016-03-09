package fms.model.maintenance;

import java.util.Date;

import fms.model.facility.Facility;
import fms.model.facility.FacilityInterface;

public class MaintenanceSchedule implements MaintenanceScheduleInterface {
	FacilityInterface facility;
	Date reserveDate;
	boolean status;
	
	public MaintenanceSchedule() {}
	
	public FacilityInterface getFacility(){
		return facility;
		
	}
	public void setFacility(FacilityInterface facility){
		this.facility=facility;
	}
	
	public Date getReserveDate(){
		return reserveDate;
		
	}
	public void setReserveDate(Date reserveDate){
		this.reserveDate=reserveDate;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status){
		this.status=status;
	}
}
