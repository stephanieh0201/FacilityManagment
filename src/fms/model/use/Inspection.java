package fms.model.use;

public class Inspection implements InspectionInterface {
	private ManagerInterface manager;
	private String reason;
	
	public String toString(){
		return "Inspection by Manager " + getManager().getEmployeeID() + " for " + getReason();
	}
	public ManagerInterface getManager() {
		return manager;
	}
	public void setManager(ManagerInterface manager) {
		this.manager = manager;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

}
