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
import fms.model.maintenance.Cost;
import fms.model.maintenance.FacilityMaintenance;
import fms.model.maintenance.Request;
import fms.model.use.Customer;
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
        
        //create a new facility and add to the database
        Facility Facility1 = new Facility();
        List<Room> rooms1 = new ArrayList<Room>();
		Room r1=new Room();
		r1.setCapacity(700);
		r1.setRoomID(100);
		r1.setFacility(Facility1);
		Room r2=new Room();
		r2.setCapacity(850);
		r2.setRoomID(101);
		r2.setFacility(Facility1);
		rooms1.add(r1);
		rooms1.add(r2);
		Details detail=new Details();
		detail.setAddress("99 Apple Valley");
		detail.setInformation("office space");
		Facility1.setDetails(detail);
		Facility1.setFacilityID(1111);
		Facility1.setRooms(rooms1);
		
		manager.addFacility(Facility1);
        
        //search db for facility maintenance object
        MaintenanceManager mManager= new MaintenanceManager();
        FacilityMaintenance test = mManager.findMaintById(1);
        System.out.println("Request for facility: " + test.getFacilityID());
        System.out.println("Request ID: " + test.getRequestID());
        
        System.out.println("Cost: " + test.getCost().getCost());
        System.out.println("Dates: " + test.getRequest().getRequestDate() + " to " + test.getRequest().getCompleteDate());
        System.out.println("Problem: " + test.getRequest().getProblem());
        
        System.out.println("-------adding new maint obj------");
        
        //create new maintenance object and add to the db
        FacilityMaintenance fm1 = new FacilityMaintenance();
        Request req = new Request();
        req.setCompleteDate("2016-05-20");
        req.setRequestDate("2016-05-03");
        req.setDays(17);
        req.setFacility(Facility1);
        req.setProblem("electrical");
        req.setRequestID(55);
        fm1.setRequest(req);
        fm1.setRequestID(req.getRequestID());
        Cost cost = new Cost();
        cost.setCost(1999);
        cost.setRequestID(55);
        fm1.setCost(cost);
        fm1.setFacility(Facility1);
        fm1.setRequest(req);
        
        mManager.addMaint(fm1);
        
        //search db for facility use object
        UseManager uManager = new UseManager();
        FacilityUse use= uManager.findUseById(123);
        System.out.println("Use for facility: " + use.getFacilityID());
        System.out.println(""
        		+ "Customer ID: " + use.getCustomerID());
        System.out.println("Start Date: " + use.getStartDate());
        System.out.println("End Date: " + use.getEndDate());
        System.out.println("Customer: " + use.getCustomer().getCustomerID() + " " + use.getCustomer().getCreditCard());
        System.out.println("Customer info: " + use.getCustomer().getFirstName()+ " " + use.getCustomer().getLastName());
        System.out.println(use.getCustomer().getAddress());
        System.out.println(use.getCustomer().getPhoneNumber());
        System.out.println(use.getCustomer().getSalary());
        System.out.println("-------adding new maint obj------");
        
		//add use objects to db
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = "2016-01-01";
		String date2 = "2016-01-03";
		FacilityUse use1 = new FacilityUse();
		Customer c2 = new Customer();
		c2.setAddress("99 strawberry lane");
		c2.setCreditCard("9999888899998888");
		c2.setFirstName("bob");
		c2.setLastName("yates");
		c2.setPhoneNumber("9876543");
		c2.setSalary(100000);
		c2.setCustomerID(333);
		c2.setUserID(900);
		use1.setFacilityID(2000);
		use1.setStartDate(date1);
		use1.setEndDate(date2);
		use1.setDays(2);
		use1.setCustomer(c2);
		uManager.addUse(use1);
	}
}
