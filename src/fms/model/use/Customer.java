package fms.model.use;

public class Customer implements CustomerInterface  {
	int customerID;
	String creditCard;
//	int userID;
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
//	@Override
//	public int getUserID() {
//		// TODO Auto-generated method stub
//		return userID;
//	}
//	@Override
//	public void setUserID(int userID) {
//		// TODO Auto-generated method stub
//		this.userID=userID;
//	}
	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}
	@Override
	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		this.firstName=firstName;
	}
	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}
	@Override
	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		this.lastName=lastName;
	}
	@Override
	public String getPhoneNumber() {
		// TODO Auto-generated method stub
		return phoneNumber;
	}
	@Override
	public void setPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		this.phoneNumber=phoneNumber;
	}
	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return address;
	}
	@Override
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		this.address=address;
	}

	
}
