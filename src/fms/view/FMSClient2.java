package fms.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fms.model.Manager.FacilityManager;
import fms.model.facility.Details;
import fms.model.facility.Facility;
import fms.model.facility.Room;


public class FMSClient2 {

	public static void main(String args[]) throws Exception {
		
		//Client will use the customer service to have access to anything related to customer functionality.
	    System.out.println("*************** Creating Facility Manager object *************************");
		FacilityManager manager = new FacilityManager();    

        System.out.println("FMSClient2: *************** trying to search facility in the database *************************");

    //Find a customer if already exists; if not, create a new one.
    Facility searchedFacility = manager.findFacilityById(2); 
    
      System.out.println("FMSClient2: *************** Here is searched customer information *************************");
      System.out.println("ID:" + searchedFacility.getFacilityID());
      List<Room> rooms = searchedFacility.getRooms();
      for (Room r:rooms){
    	  System.out.println("Room ID:" + r.getRoomID());
          System.out.println("Capacity:"+ r.getCapacity());
    	  
      }
      System.out.println("Facility "+ searchedFacility.getFacilityID() + " capacity: " + searchedFacility.requestAvailableCapacity());
      System.out.println("-----------");
      Facility Facility1 = new Facility();
      List<Room> rooms1 = new ArrayList<Room>();
		Room r1=new Room();
		Room r2=new Room();
		r1.setCapacity(1000);
		r1.setRoomID(99);
		r1.setFacility(Facility1);
		r2.setCapacity(300);
		r2.setRoomID(98);
		r2.setFacility(Facility1);
		rooms1.add(r1);
		rooms1.add(r2);
		//rooms1.add(new Room(100, 1));
		//rooms1.add(new Room(50,2));
		//rooms1.add(new Room(120,3));
		//rooms1.add(new Room(15,4));

		List<Room> rooms2 = new ArrayList<Room>();
		Room r3=new Room();
		r3.setCapacity(5000);
		r3.setRoomID(100);
		//rooms2.add(new Room(1000,5));
		//rooms2.add(new Room(2500,6));
		rooms2.add(r3);
		System.out.println("creating facilities with rooms");
		
		Details detail1=new Details();
		
		detail1.setAddress("123 Main St");
		detail1.setInformation("business building");
		Facility1.setDetails(detail1);
		
		Facility1.setFacilityID(876);
	//	Facility1.setFacilityInformation("business building");
		Facility1.setRooms(rooms1);
		manager.addFacility(Facility1);
	}
}
