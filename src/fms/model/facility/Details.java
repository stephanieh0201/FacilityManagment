package fms.model.facility;

public class Details implements DetailsInterface {
	String address;
	String information;
	int facilityID;
	
	
	public Details() {}
	
	public void setFacilityID(int facilityID){
		this.facilityID=facilityID;
	}
	public int getFacilityID(){
		return facilityID;
	}
	
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress() {
		return address;
	}
	public void setInformation(String information) {
		this.information=information;
	}
	public String getInformation() {
		return information;
	}
	
	@Override
	public String toString() {
		return "Address: " + getAddress() + "\nInformation: " + getInformation();
	}
}
