package fms.model.use;

public class Manager implements ManagerInterface  {
	private int employeeID;
	private double salary;
	private int inspectionID;
//	private int userID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	public Manager() { 

	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getInspectionID() {
		return inspectionID;
	}

	public void setInspectionID(int inspectionID) {
		this.inspectionID = inspectionID;
	}

//	@Override
//	public int getUserID() {
//		// TODO Auto-generated method stub
//		return userID;
//	}
//
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
