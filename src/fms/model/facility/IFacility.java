package fms.model.facility;

import java.util.List;

public interface IFacility {
	public void listFacilities();
	public String getFacilityInformation();
	public int requestAvailableCapacity();
	public void addNewFacility();
	public void addFacilityDetail();
	public boolean removeFacility();
	

}
