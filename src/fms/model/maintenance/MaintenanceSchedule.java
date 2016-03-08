package fms.model.maintenance;

import java.util.Date;

import fms.model.facility.Facility;

public class MaintenanceSchedule implements MaintenanceScheduleInterface {
	Facility facility;
	Date reserveDate;
	boolean status;
	
	public MaintenanceSchedule() {}
	
	public Facility getFacility(){
		return facility;
		
	}
	public void setFacility(Facility facility){
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
