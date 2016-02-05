package fms.model.use;

import java.util.Date;

import fms.model.facility.Facility;

public interface IFacilityUse {
	public boolean isInUseDuringInterval(Date startDate, Date endDate);
	public void assignFacilityToUse(Facility facility, User user);
	public void vacateFacility();
	public void listInspections();
	public int listActualUsage();
	public int calcUsageRate();

}
