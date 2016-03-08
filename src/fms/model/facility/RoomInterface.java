package fms.model.facility;

public interface RoomInterface {
	public int getCapacity();
	public void setCapacity(int capacity);
	public int getRoomID();
	public void setRoomID(int roomID);
	public FacilityInterface getFacility();
	public void setFacility(FacilityInterface facility);

}

