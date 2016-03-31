package fms.model.use;

public interface ManagerInterface extends UserInterface {
	public int getEmployeeID();
	public void setEmployeeID(int employeeID);
	public double getSalary();
	public void setSalary(double salary);
	public int getInspectionID();
	public void setInspectionID(int inspectionID);
}
