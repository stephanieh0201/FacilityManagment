package fms.model.use;

import java.util.Date;
import java.util.List;

import fms.model.facility.Facility;
import fms.model.facility.FacilityInterface;

public interface FacilityUseInterface {
	public boolean isInUseDuringInterval(Date startDate, Date endDate);
	public CustomerInterface assignFacilityToUse(FacilityInterface facility, CustomerInterface customer);
	public CustomerInterface vacateFacility();
	public List<InspectionInterface> listInspections();
	public int listActualUsage();
	public int calcUsageRate();

}
