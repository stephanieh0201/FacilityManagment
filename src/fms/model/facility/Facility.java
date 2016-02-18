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
		facilityList.add(this);
		
	}
	@Override
	public String toString() {
		String id = Integer.toString(facilityID);
		return id;
	}
	public int getFacilityID() {
		return facilityID;
	}
	
	public void setFacilityID(int facilityID) {
		this.facilityID=facilityID;
	}
	
	
	@Override
	public List<Facility> listFacilities() {
		
		return facilityList;

	}

	public List<Room> getRooms() {
		return roomsList;
	}
	
	public void setRooms(List<Room> roomsList) {
		this.roomsList=roomsList;
	}
	
	@Override
	public Details getFacilityInformation() {
		return details;
	}
	

	//public void setFacilityInformation(String information) {
		//details.setInformation(information);
//	}
	
	@Override
	public int requestAvailableCapacity() {
		int capacity=0;
		for (Room room : roomsList) {
			capacity+= room.getCapacity();
		}
		return capacity;
	
	}
	
	
	@Override
	public void addNewFacility(Room room) {
		roomsList.add(room); 
	}
	
	@Override
	public void addFacilityDetail(Details details) {
		this.details=details;
	}
	
	@Override
	public Room removeFacility(Room room) {
		boolean remove = roomsList.remove(room);
		if (remove==true) {System.out.println("Room " + room.getRoomID()+  " has been removed.");}
		else System.out.println("Unable to remove room " + room.getRoomID());
		return room;
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