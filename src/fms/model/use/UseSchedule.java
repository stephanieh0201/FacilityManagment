package fms.model.use;

import java.util.Date;

import fms.model.facility.Facility;
import fms.model.facility.FacilityInterface;

public class UseSchedule implements UseScheduleInterface {
	private FacilityInterface facility;
	private boolean isInUse;
	private Date useDate;
	
	
	public FacilityInterface getFacility() {
		return facility;
	}
	public void setFacility(FacilityInterface facility) {
		this.facility = facility;
	}
	public boolean isInUse() {
		return isInUse;
	}
	public void setInUse(boolean isInUse) {
		this.isInUse = isInUse;
	}
	public Date getUseDate() {
		return useDate;
	}
	public void setUseDate(Date useDate) {
		this.useDate = useDate;
	}
}
