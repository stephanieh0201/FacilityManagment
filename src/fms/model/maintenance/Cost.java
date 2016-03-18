package fms.model.maintenance;

public class Cost implements CostInterface {
	int maintenanceID;
	int maintenanceCost;
	
	
	public Cost() {
		
	}
	public int getMaintenanceCost(){
		return maintenanceCost;
	}
	public void setMaintenanceCost(int maintenanceCost){
		this.maintenanceCost=maintenanceCost;
		
	}
	public int getMaintenanceID(){
		return maintenanceID;
	}
	public void setMaintenanceID(int maintenanceID){
		this.maintenanceID=maintenanceID;
	}
	
	
}
