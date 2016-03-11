package fms.model.use;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fms.model.facility.*;
import fms.model.use.*;



public class FacilityUse implements FacilityUseInterface {
	private CustomerInterface customer;
	private FacilityInterface facility;
	private Date startDate;
	private Date endDate;
	private List<InspectionInterface> inspections;
	private int rate = 200;
	private UseScheduleInterface useSchedule;
	private int facilityID;
	private int customerID;
	
	
	public FacilityUse() {
	}

	@Override
	public boolean isInUseDuringInterval(Date startDate, Date endDate) {
		int days= this.endDate.compareTo(this.startDate) + 1;
		long milliInADay = 1000 * 60 * 60 * 24;
		for (int i=0; i<=days; i++){
			Date checkDate = new Date (getStartDate().getTime()+(i*milliInADay));
			if (checkDate.equals(startDate)||checkDate.equals(endDate) || (checkDate.after(startDate)&& checkDate.before(endDate))){return true;}
		}
		return false;
	}

	@Override
	public CustomerInterface assignFacilityToUse(FacilityInterface facility, CustomerInterface customer) {
		 facility.setUser(customer);	
		 return customer;
	}

	@Override
	public CustomerInterface vacateFacility() {
		setCustomer(null);
		return getCustomer();
	}

	@Override
	public List<InspectionInterface> listInspections() {
		return inspections;
		
	}

	@Override
	public int listActualUsage() {
		int days = endDate.compareTo(startDate) +1;
		return days;
	}

	@Override
	public int calcUsageRate() {
		int days = endDate.compareTo(startDate) +1;
		return days*rate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public FacilityInterface getFacility() {
		return facility;
	}

	public void setFacility(FacilityInterface facility) {
		this.facility = facility;
	}

	public List<InspectionInterface> getInspections() {
		return this.inspections;
	}

	public void setInspections(List<InspectionInterface> inspections) {
		this.inspections = inspections;
	}
	public void addInspection(InspectionInterface inspection){
		inspections.add(inspection);
	}

	public CustomerInterface getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerInterface customer) {
		this.customer = customer;
	}

	public UseScheduleInterface getUseSchedule() {
		return useSchedule;
	}

	public void setUseSchedule(UseScheduleInterface useSchedule) {
		this.useSchedule = useSchedule;
	}

	public int getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(int facilityID) {
		this.facilityID = facilityID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}


}
