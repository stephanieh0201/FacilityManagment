package fms.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


import fms.model.facility.Facility;
import fms.model.facility.Room;
import fms.model.facilityManager.FacilityManager;


public class FMSClient2 {

	public static void main(String args[]) throws Exception {
		
		//Client will use the customer service to have access to anything related to customer functionality.
	    System.out.println("*************** Creating Facility Manager object *************************");
		FacilityManager manager = new FacilityManager();    

        System.out.println("FMSClient2: *************** trying to search facility in the database *************************");

    //Find a customer if already exists; if not, create a new one.
    Facility searchedFacility = manager.findFacilityById(2); 
    
      System.out.println("FMSClient2: *************** Here is searched customer information *************************");
      System.out.println("ID:" + searchedFacility.getFacilityID() + " " + searchedFacility.getFacilityInformation());
      List<Room> rooms = searchedFacility.getRooms();
      for (Room r:rooms){
    	  System.out.println("Room ID:" + r.getRoomID());
          System.out.println("Capacity:"+ r.getCapacity());
    	  
      }
      System.out.println("Facility "+ searchedFacility.getFacilityID() + " capacity: " + searchedFacility.requestAvailableCapacity());
      
	}
}
