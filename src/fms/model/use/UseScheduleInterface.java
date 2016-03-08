package fms.model.use;

import java.util.Date;

import fms.model.facility.FacilityInterface;

public interface UseScheduleInterface {
	public FacilityInterface getFacility();
	public void setFacility(FacilityInterface facility);
	public boolean isInUse();
	public void setInUse(boolean isInUse);
	public Date getUseDate();
	public void setUseDate(Date useDate);
}
