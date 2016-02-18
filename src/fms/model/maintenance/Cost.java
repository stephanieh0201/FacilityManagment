package fms.model.maintenance;

public class Cost {
	int requestID;
	int maintenanceCost;
	
	
	public Cost(){
		
	}
	public int getCost(){
		return maintenanceCost;
	}
	public void setCost(int maintenanceCost){
		this.maintenanceCost=maintenanceCost;
		
	}
	public int getRequestID(){
		return requestID;
	}
	public void setRequestID(int requestID){
		this.requestID=requestID;
	}
	
}
