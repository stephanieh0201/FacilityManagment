package fms.model.use;

public class Customer extends User {
	int customerID;
	String creditCard;
	int userID;
	
	
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

	
}
