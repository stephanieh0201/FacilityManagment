package fms.model.facility;

import java.util.*;

import fms.model.use.Customer;
import fms.model.use.IFacilityUse;
import fms.model.use.User;

public class Facility implements IFacility {
	private int facilityID;
	private List<IRoom> roomsList;
	private ICustomer customer;
	private IDetails details;

	
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
	public List<IRoom> listFacilities() {
		return roomsList;

	}

	public List<IRoom> getRooms() {
		return roomsList;
	}
	
	public void setRooms(List<IRoom> roomsList) {
		this.roomsList=roomsList;
	}
	
	@Override
	public IDetails getFacilityInformation() {
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
	public IRoom addNewFacility(IRoom room) {
		roomsList.add(room); 
		return room;
	}
	
	@Override
	public void addFacilityDetail(IDetails details) {
		this.details=details;
	}
	
	@Override
	public IRoom removeFacility(IRoom room) {
		roomsList.remove(room);
		return room;
	}

	public ICustomer getUser() {
		return customer;
	}

	public void setUser(ICustomer customer) {
		this.customer = customer;
	}

	public IDetails getDetails() {
		return details;
	}

	public void setDetails(IDetails details) {
		this.details = details;
	}
}