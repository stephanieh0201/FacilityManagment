package fms.model.facility;

public class Room implements RoomInterface {
	private int capacity;
	private int roomID;
//	private FacilityInterface facility;
	private int facilityID;
	
	public Room() {

	}
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity=capacity;
	}
	
	public int getRoomID(){
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID=roomID;
	}

//	public FacilityInterface getFacility() {
		//return facility;
	//}

//	public void setFacility(FacilityInterface facility) {
	//	this.facility = facility;
	//}
	public String toString(){
		return "Room"+ "ID: " + getRoomID() + " Capacity: " + getCapacity();
	}

	public int getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(int facilityID) {
		this.facilityID = facilityID;
	}
}
