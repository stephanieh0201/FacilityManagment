package fms.model.use;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fms.model.facility.*;


public class FacilityUse implements IFacilityUse {
	private Customer customer;
	private Facility facility;
	private Date startDate;
	private Date endDate;
	private List<Inspection> inspections;
	private int rate = 200;
	private UseSchedule useSchedule;
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
	public Customer assignFacilityToUse(Facility facility, Customer customer) {
		 facility.setUser(customer);	
		 return customer;
	}

	@Override
	public Customer vacateFacility() {
		setCustomer(null);
		return getCustomer();
	}

	@Override
	public List<Inspection> listInspections() {
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

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public List<Inspection> getInspections() {
		return this.inspections;
	}

	public void setInspections(List<Inspection> inspections) {
		this.inspections = inspections;
	}
	public void setInspections(Inspection inspection){
		inspections.add(inspection);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public UseSchedule getUseSchedule() {
		return useSchedule;
	}

	public void setUseSchedule(UseSchedule useSchedule) {
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
