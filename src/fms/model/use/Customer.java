package fms.model.use;

public class Customer implements CustomerInterface  {
	int customerID;
	String creditCard;
	int useID;
	String firstName;
	String lastName;
	String phoneNumber;
	String address;
	
	
	
	public Customer(){
		
	}
	public String toString() {
		return "CustomerID: " + getCustomerID() + " Name: " + getLastName() + ", " + getFirstName();
	}
	public void setCustomerID(int customerID) {
		this.customerID=customerID;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard=creditCard;
	}
	
	public String getCreditCard() {
		return creditCard;
	}
	public void setUseID(int useID){
		this.useID=useID;
	}
	public int getUseID(){
		return useID;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}
	
	@Override
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	
	@Override
	public String getLastName() {
		return lastName;
	}
	
	@Override
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	
	@Override
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	@Override
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber=phoneNumber;
	}
	
	@Override
	public String getAddress() {
		return address;
	}
	
	@Override
	public void setAddress(String address) {
		this.address=address;
	}

	
}
