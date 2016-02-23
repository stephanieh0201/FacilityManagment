package fms.model.facility;

public class Room {
	private int capacity;
	private int roomID;
	private Facility facility;
	
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

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	public String toString(){
		return "Room"+ "ID: " + getRoomID() + " Capacity: " + getCapacity();
	}
}
