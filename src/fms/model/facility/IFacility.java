package fms.model.facility;

import java.util.ArrayList;
import java.util.List;

public interface IFacility {
	public List<Room> listFacilities();
	public Details getFacilityInformation();
	public int requestAvailableCapacity();
	public Room addNewFacility(Room room);
	public void addFacilityDetail(Details details);
	public Room removeFacility(Room room);
	

}
