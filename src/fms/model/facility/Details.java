package fms.model.facility;

public class Details implements IDetails {
	String address;
	String information;
	
	public Details() {}
	
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
