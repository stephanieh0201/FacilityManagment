package fms.model.facility;

public interface IRoom {
	public int getCapacity();
	public void setCapacity(int capacity);
	public int getRoomID();
	public void setRoomID(int roomID);
	public IFacility getFacility();
	public void setFacility(IFacility facility);

}

