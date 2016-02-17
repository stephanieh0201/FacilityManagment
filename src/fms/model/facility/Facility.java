package fms.model.facility;

import java.util.*;

import fms.model.use.Customer;
import fms.model.use.IFacilityUse;
import fms.model.use.User;

public class Facility implements IFacility {
	private int facilityID;
	private List<Room> roomsList;
	private static List<Facility>facilityList=new ArrayList<Facility>();
	private Customer customer;
	private Details details;

	
	public Facility() {
//		this.facilityID=facilityID;
//		this.information=information;
//		this.roomsList=roomsList;
//		facilityList.add(this);
		
	}

	public int getFacilityID() {
		return facilityID;
	}
	
	public void setFacilityID(int facilityID) {
		this.facilityID=facilityID;
	}
	
	
	@Override
	public void listFacilities() {
		for (Facility f : facilityList) {
			System.out.println(f.getFacilityID());
		}
	}

	public List<Room> getRooms() {
		return roomsList;
	}
	
	public void setRooms(List<Room> roomsList) {
		this.roomsList=roomsList;
	}
	
	@Override
	public String getFacilityInformation() {
		return details.getInformation();
	}
	

	public void setFacilityInformation(String information) {
		details.setInformation(information);
	}
	
	@Override
	public int requestAvailableCapacity() {
		int capacity=0;
		for (Room room : roomsList) {
			capacity+= room.getCapacity();
		}
		return capacity;
	
	}
	
	
	@Override
	public void addNewFacility() {
		
	}
	
	@Override
	public void addFacilityDetail() {
		
	}
	
	@Override
	public boolean removeFacility() {
		return false;
	}

	public Customer getUser() {
		return customer;
	}

	public void setUser(Customer customer) {
		this.customer = customer;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}
}