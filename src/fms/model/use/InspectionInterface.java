package fms.model.use;

public interface InspectionInterface {
	public ManagerInterface getManager();
	public void setManager(ManagerInterface manager);
	public String getReason();
	public void setReason(String reason);
	public int getInspectionID();
	public void setInspectionID(int inspectionID);
	public int getUseID();
	public void setUseID(int useID);
}
