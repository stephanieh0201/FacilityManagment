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
	private List<User> users;
	private List<String> inspections=new ArrayList<String>();
	private int rate = 200;
	private List<UseSchedule> schedule;
	private int customerID;
	private int facilityID;
	private UseSchedule useSchedule;
	
	
	public FacilityUse() {

	}

	@Override
	public boolean isInUseDuringInterval(Date startDate, Date endDate) {
		int days= this.endDate.compareTo(this.startDate) + 1;
		System.out.println(days);
		long milliInADay = 1000 * 60 * 60 * 24;
		for (int i=0; i<=days; i++){
			Date checkDate = new Date (getStartDate().getTime()+(i*milliInADay));
			System.out.println("checkdate is: "+checkDate);
			System.out.println("checkdate is after start: " + checkDate.after(startDate));

			if (checkDate.equals(startDate)||checkDate.equals(endDate) || (checkDate.after(startDate)&& checkDate.before(endDate))){return true;}
		}
		return false;
	}

	@Override
	public void assignFacilityToUse(Facility facility, Customer customer) {
		facility.setUser(customer);	
	}

	@Override
	public Facility vacateFacility() {
		this.facility.setUser(null);
		return facility;
	}

	@Override
	public List<String> listInspections() {
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public List<String> getInspections() {
		return inspections;
	}

	public void setInspections(List<String> inspections) {
		this.inspections = inspections;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(int facilityID) {
		this.facilityID = facilityID;
	}

	public List<UseSchedule> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<UseSchedule> schedule) {
		this.schedule = schedule;
	}

	public UseSchedule getUseSchedule() {
		return useSchedule;
	}

	public void setUseSchedule(UseSchedule useSchedule) {
		this.useSchedule = useSchedule;
	}


}
