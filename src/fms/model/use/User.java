package fms.model.use;

public class User implements UserInterface {
//	private int userID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	public User() {
	}

//	public int getUserID() {
//		return userID;
//	}
//
//	public void setUserID(int userID) {
//		this.userID = userID;
//	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
