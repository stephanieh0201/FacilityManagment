package fms.model.use;

public class Customer extends User {
	int customerID;
	String creditCard;
	double salary;
	int userID;
	
	
	public Customer(){
		
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
	
	public void setSalary(double salary) {
		this.salary=salary;
	}
	
	public double getSalary() {
		return salary;
	}
	public void setUserID(int userID) {
		this.userID=userID;
	}
	public int getCUserID(){
		return userID;
	}
	
}
