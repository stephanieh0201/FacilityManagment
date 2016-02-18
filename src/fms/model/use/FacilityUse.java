package fms.model.use;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fms.model.facility.*;


public class FacilityUse implements IFacilityUse {
	private Customer customer;
	private Date startDate;
	private Date endDate;
	private List<User> users=new ArrayList<User>();
	private boolean isInUse;
	private Facility facility;
	private List<String> inspections=new ArrayList<String>();
	private int rate = 200;
	
	
	public FacilityUse(Facility facility, Date startDate, Date endDate) {
		this.facility=facility;
		this.startDate=startDate;
		this.endDate=endDate;
		isInUse=true;
	}

	@Override
	public boolean isInUseDuringInterval(Date startDate, Date endDate) {
		return isInUse;
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




}
