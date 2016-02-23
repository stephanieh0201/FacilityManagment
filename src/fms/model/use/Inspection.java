package fms.model.use;

public class Inspection {
	private Manager manager;
	private String reason;
	
	public String toString(){
		return "Inspection by Manager " + getManager().getEmployeeID() + " for " + getReason();
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

}
