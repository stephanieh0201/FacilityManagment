package fms.model.use;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fms.model.facility.*;


public class FacilityUse implements IFacilityUse {
	private Date startDate;
	private Date endDate;
	private List<User> users=new ArrayList<User>();
	private boolean isInUse;
	private Facility facility;
	private List<String> inspections=new ArrayList<String>();
	private int rate = 200;
	
	
	public FacilityUse() {	}

	@Override
	public boolean isInUseDuringInterval(Date startDate, Date endDate) {
		return isInUse;
	}

	@Override
	public void assignFacilityToUse(Facility facilty, User user) {
		facility.setUser(user);	
		
	}

	@Override
	public void vacateFacility() {
		this.facility.setUser(null);
		
	}

	@Override
	public void listInspections() {
		for (String s : inspections) {
			System.out.println(s);
		}
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




}
