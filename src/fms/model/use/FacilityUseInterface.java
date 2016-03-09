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
	public Date getStartDate();
	public void setStartDate(Date startDate);
	public Date getEndDate();
	public void setEndDate(Date endDate);
	public FacilityInterface getFacility();
	public void setFacility(FacilityInterface facility);
	public List<InspectionInterface> getInspections();
	public void setInspections(List<InspectionInterface> inspections);
	public void setInspections(InspectionInterface inspection);
	public CustomerInterface getCustomer();
	public void setCustomer(CustomerInterface customer);
	public UseScheduleInterface getUseSchedule();
	public void setUseSchedule(UseScheduleInterface useSchedule);
	public int getFacilityID();
	public void setFacilityID(int facilityID);
	public int getCustomerID();
	public void setCustomerID(int customerID);

}
