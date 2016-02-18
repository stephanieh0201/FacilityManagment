package fms.model.facility;

import java.util.List;

public interface IFacility {
	public List<Facility> listFacilities();
	public Details getFacilityInformation();
	public int requestAvailableCapacity();
	public void addNewFacility(Room room);
	public void addFacilityDetail(Details details);
	public Room removeFacility(Room room);
	

}
