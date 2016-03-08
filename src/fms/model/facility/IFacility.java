package fms.model.facility;

import java.util.ArrayList;
import java.util.List;

public interface IFacility {
	public List<IRoom> listFacilities();
	public IDetails getFacilityInformation();
	public int requestAvailableCapacity();
	public IRoom addNewFacility(IRoom room);
	public void addFacilityDetail(IDetails details);
	public IRoom removeFacility(IRoom room);
	public int getFacilityID();
	public void setFacilityID(int facilityID) ;
	public List<IRoom> getRooms();
	public void setRooms(List<IRoom> roomsList);
	public ICustomer getUser();
	public void setUser(ICustomer customer);
	public IDetails getDetails();
	public void setDetails(IDetails details);
}
