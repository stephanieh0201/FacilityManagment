package fms.model.facility;

public class Room implements IRoom {
	private int capacity;
	private int roomID;
	private IFacility facility;
	
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

	public IFacility getFacility() {
		return facility;
	}

	public void setFacility(IFacility facility) {
		this.facility = facility;
	}
	public String toString(){
		return "Room"+ "ID: " + getRoomID() + " Capacity: " + getCapacity();
	}
}
