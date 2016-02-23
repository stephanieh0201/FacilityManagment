package fms.model.use;

import java.util.Date;
import java.util.List;

import fms.model.facility.Facility;

public interface IFacilityUse {
	public boolean isInUseDuringInterval(Date startDate, Date endDate);
	public Customer assignFacilityToUse(Facility facility, Customer customer);
	public Customer vacateFacility();
	public List<Inspection> listInspections();
	public int listActualUsage();
	public int calcUsageRate();

}
