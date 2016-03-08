package fms.model.facility;

import java.util.*;

import fms.model.use.Customer;
import fms.model.use.CustomerInterface;
import fms.model.use.FacilityUseInterface;
import fms.model.use.User;

public class Facility implements FacilityInterface {
	private int facilityID;
	private List<RoomInterface> roomsList;
	private CustomerInterface customer;
	private DetailsInterface details;

	
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
	public List<RoomInterface> listFacilities() {
		return roomsList;

	}

	public List<RoomInterface> getRooms() {
		return roomsList;
	}
	
	public void setRooms(List<RoomInterface> roomsList) {
		this.roomsList=roomsList;
	}
	
	@Override
	public DetailsInterface getFacilityInformation() {
		return details;
	}
	


	
	@Override
	public int requestAvailableCapacity() {
		int capacity=0;
		for (RoomInterface room : roomsList) {
			capacity+= room.getCapacity();
		}
		return capacity;
	
	}
	
	
	@Override
	public RoomInterface addNewFacility(RoomInterface room) {
		roomsList.add(room); 
		return room;
	}
	
	@Override
	public void addFacilityDetail(DetailsInterface details) {
		this.details=details;
	}
	
	@Override
	public RoomInterface removeFacility(RoomInterface room) {
		roomsList.remove(room);
		return room;
	}

	public CustomerInterface getUser() {
		return customer;
	}

	public void setUser(CustomerInterface customer) {
		this.customer = customer;
	}

	public DetailsInterface getDetails() {
		return details;
	}

	public void setDetails(DetailsInterface details) {
		this.details = details;
	}
}