package fms.model.use;

public class Inspection implements InspectionInterface {
	private ManagerInterface manager;
	private String reason;
	private int inspectionID;
	private int useID;
	
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
	public int getInspectionID() {
		return inspectionID;
	}
	public void setInspectionID(int inspectionID) {
		this.inspectionID = inspectionID;
	}
	public int getUseID() {
		return useID;
	}
	public void setUseID(int useID) {
		this.useID = useID;
	}

}
