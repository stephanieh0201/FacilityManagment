package fms.model.use;

public class Manager implements ManagerInterface  {
	private int employeeID;
	private double salary;
	private int inspectionID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	public Manager() {}
	
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
