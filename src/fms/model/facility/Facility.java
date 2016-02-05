package fms.model.facility;

import java.util.*;

import fms.model.use.User;

public class Facility implements IFacility {
	private int facilityID;
	private String information;
	private List<Room> roomsList;
	private static List<Facility>facilityList=new ArrayList<Facility>();
	private User user;

	
	public Facility(int facilityID, String information, List<Room> roomsList) {
		this.facilityID=facilityID;
		this.information=information;
		this.roomsList=roomsList;
		facilityList.add(this);
		
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
		return information;
	}
	

	public void setFacilityInformation(String information) {
		this.information=information;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}