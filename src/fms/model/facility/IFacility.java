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
	

}
