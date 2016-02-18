package fms.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fms.model.Manager.FacilityManager;
import fms.model.Manager.MaintenanceManager;
import fms.model.Manager.UseManager;
import fms.model.facility.Details;
import fms.model.facility.Facility;
import fms.model.facility.Room;
import fms.model.maintenance.FacilityMaintenance;
import fms.model.use.FacilityUse;


public class FMSClient2 {

	public static void main(String args[]) throws Exception {
		
		//Client will use the facility manager to have access to anything related to facility functionality.
	    System.out.println("*************** Creating Facility Manager object *************************");
		FacilityManager manager = new FacilityManager();    

        System.out.println("FMSClient2: *************** trying to search facility in the database *************************");

        //Find a facility 
        Facility searchedFacility = manager.findFacilityById(2); 
    
        System.out.println("FMSClient2: *************** Here is searched facility information *************************");
        System.out.println("ID:" + searchedFacility.getFacilityID());
        List<Room> rooms = searchedFacility.getRooms();
        for (Room r:rooms){
        	System.out.println("Room ID:" + r.getRoomID());
        	System.out.println("Capacity:"+ r.getCapacity());
    	}
        System.out.println("Facility "+ searchedFacility.getFacilityID() + " capacity: " + searchedFacility.requestAvailableCapacity());
        System.out.println("Facility detials: " + searchedFacility.getDetails().toString());
        System.out.println("-----------");
        
        /*//create a new facility and add to the database
        Facility Facility1 = new Facility();
        List<Room> rooms1 = new ArrayList<Room>();
		Room r1=new Room();
		r1.setCapacity(1000);
		r1.setRoomID(99);
		r1.setFacility(Facility1);
		Room r2=new Room();
		r2.setCapacity(300);
		r2.setRoomID(98);
		r2.setFacility(Facility1);
		rooms1.add(r1);
		rooms1.add(r2);
		Details detail=new Details();
		detail.setAddress("123 Main St");
		detail.setInformation("business building");
		Facility1.setDetails(detail);
		Facility1.setFacilityID(876);
		Facility1.setRooms(rooms1);
		
		manager.addFacility(Facility1);*/
        
        //search db for facility maintenance object
        MaintenanceManager mManager= new MaintenanceManager();
        FacilityMaintenance test = mManager.findMaintById(1);
        System.out.println("Request for facility: " + test.getFacilityID());
        System.out.println("Request ID: " + test.getRequestID());
        System.out.println("-------adding new maint obj------");
        
        //create new maintenance object and add to the db
        FacilityMaintenance fm1 = new FacilityMaintenance();
        fm1.setRequestID(400);
        fm1.setFacilityID(123);
        mManager.addMaint(fm1);
        
        //search db for facility use object
        UseManager uManager = new UseManager();
        FacilityUse use= uManager.findUseById(123);
        System.out.println("Use for facility: " + use.getFacilityID());
        System.out.println("Customer ID: " + use.getCustomerID());
        System.out.println("Start Date: " + use.getStartDate());
        System.out.println("End Date: " + use.getEndDate());
        
        System.out.println("-------adding new maint obj------");
        
		
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = "2016-01-01";
		String date2 = "2016-01-03";
		FacilityUse use1 = new FacilityUse();
		use1.setCustomerID(9);
		use1.setFacilityID(2000);
		use1.setStartDate(date1);
		use1.setEndDate(date2);
		use1.setDays(2);
		uManager.addUse(use1);
	}
}
