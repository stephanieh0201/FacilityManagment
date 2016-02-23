package fms.model.facility;

import java.util.*;

import fms.model.use.Customer;
import fms.model.use.IFacilityUse;
import fms.model.use.User;

public class Facility implements IFacility {
	private int facilityID;
	private List<Room> roomsList;
	private Customer customer;
	private Details details;

	
	public Facility() {
		
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
	public List<Room> listFacilities() {
		return roomsList;

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
	


	
	@Override
	public int requestAvailableCapacity() {
		int capacity=0;
		for (Room room : roomsList) {
			capacity+= room.getCapacity();
		}
		return capacity;
	
	}
	
	
	@Override
	public Room addNewFacility(Room room) {
		roomsList.add(room); 
		return room;
	}
	
	@Override
	public void addFacilityDetail(Details details) {
		this.details=details;
	}
	
	@Override
	public Room removeFacility(Room room) {
		roomsList.remove(room);
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