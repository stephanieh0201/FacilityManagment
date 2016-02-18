package fms.model.use;

import java.util.Date;
import java.util.List;

import fms.model.facility.Facility;

public interface IFacilityUse {
	public boolean isInUseDuringInterval(String startDate, String endDate);
	public void assignFacilityToUse(Facility facility, Customer customer);
	public Facility vacateFacility();
	public List<String> listInspections();
	public int listActualUsage();
	public int calcUsageRate();

}
