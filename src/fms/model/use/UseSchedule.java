package fms.model.use;

import java.util.Date;

import fms.model.facility.Facility;

public class UseSchedule {
	private Facility facility;
	private boolean isInUse;
	private Date useDate;
	
	
	public Facility getFacility() {
		return facility;
	}
	public void setFacility(Facility facility) {
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
