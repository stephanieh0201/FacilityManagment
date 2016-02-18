package fms.model.maintenance;

public class Cost {
	Request request;
	int maintenanceCost;
	
	
	public Cost(String problem){
		
		if (problem=="electrical") { 
			maintenanceCost=200;
		}
		if (problem=="plumbing") { 
			maintenanceCost=100;
		}
		
	}
	public int getCost(){
		return maintenanceCost;
	}
	
}
