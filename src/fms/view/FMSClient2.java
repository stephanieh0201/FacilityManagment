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

import javax.xml.soap.Detail;

import fms.model.facility.Details;
import fms.model.facility.Facility;
import fms.model.facility.Room;
import fms.model.facility.RoomInterface;
import fms.model.maintenance.Cost;
import fms.model.maintenance.FacilityMaintenance;
import fms.model.maintenance.MaintenanceSchedule;
import fms.model.maintenance.Problem;
import fms.model.maintenance.Request;
import fms.model.manager.FacilityManager;
import fms.model.manager.MaintenanceManager;
import fms.model.manager.UseManager;
import fms.model.use.Customer;
import fms.model.use.FacilityUse;
import fms.model.use.Inspection;
import fms.model.use.Manager;
import fms.model.use.UseSchedule;


public class FMSClient2 {

	public static void main(String args[]) throws Exception {
		
		//Client will use the facility manager to have access to anything related to facility & its description
	    System.out.println("*************** Creating Facility Manager object *************************");
		FacilityManager manager = new FacilityManager();    

        System.out.println("FMSClient2: *************** trying to search facility in the database *************************");

        //Find a facility 
        Facility searchedFacility = manager.findFacilityById(2); 
    
        System.out.println("FMSClient2: *************** Here is searched facility information *************************");
        System.out.println("ID:" + searchedFacility.getFacilityID());
        List<RoomInterface> rooms = searchedFacility.getRooms();
        for (RoomInterface r:rooms){
        	System.out.println("Room ID:" + r.getRoomID());
        	System.out.println("Capacity:"+ r.getCapacity());
    	}
        System.out.println("Facility "+ searchedFacility.getFacilityID() + " capacity: " + searchedFacility.requestAvailableCapacity());
        System.out.println("Facility details: " + searchedFacility.getDetails().toString());
        
        System.out.println("\nFacility Interface Methods:");
        System.out.println("List Facilities: " + searchedFacility.listFacilities());
        System.out.println("Get Facility Info: " + searchedFacility.getFacilityInformation());
        System.out.println("Request Available capacity: " + searchedFacility.requestAvailableCapacity());
        Room roomAdd = new Room();
        roomAdd.setCapacity(300);
        roomAdd.setFacility(searchedFacility);
        roomAdd.setRoomID(3);
        System.out.println("Adding new facility: " + searchedFacility.addNewFacility(roomAdd));
        Details d = new Details();
        d.setAddress("123 america road");
        d.setInformation("building moved locations");
        System.out.println("Adding facility details." );
        searchedFacility.addFacilityDetail(d);
        System.out.println("Removing facility: " + searchedFacility.removeFacility(roomAdd));
        
        System.out.println("-----------");
        
        //create a new facility to be added to database
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
		Facility1.setFacilityID(9999);
		Facility1.setRooms(rooms1);
		//add the facility to the database
		manager.addFacility(Facility1);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = formatter.parse("2016-02-22");
		Date date2 = formatter.parse("2016-02-23");
        //search db for facility maintenance object
        MaintenanceManager mManager= new MaintenanceManager();
        FacilityMaintenance searchedMaint = mManager.findMaintById(1);
        System.out.println("Request for facility: " + searchedMaint.getFacilityID());
        System.out.println("Request ID: " + searchedMaint.getRequestID());
        
        System.out.println("Cost: " + searchedMaint.getCost().getCost());
        System.out.println("Dates: " + searchedMaint.getRequest().getRequestDate() + " to " + searchedMaint.getRequest().getCompleteDate());
        System.out.println("Problem: " + searchedMaint.getRequest().getProblem());
        
        System.out.println("\nFacility Maintenance Methods: ");
        Request r= new Request();
        r.setCompleteDate(date2);
        r.setRequestDate(date1);
        r.setFacility(searchedFacility);
        r.setRequestID(199);
        Problem p = new Problem();
        p.setProblem("fire alarm");
        p.setProblemID(5);
        r.setProblem(p);
        System.out.println("Making Facility Maint Request: " + searchedMaint.makeFacilityMaintRequest(r));
        Date reqDate = formatter.parse("2016-02-22");
        Date comDate= formatter.parse("2016-02-24");
        System.out.println("Schedule Maintenance: " + searchedMaint.scheduleMaintenance(reqDate, comDate) );
        System.out.println("Calculate Maint Cost for Facility: " + searchedMaint.calcMaintenanceCostForFacility(r));
        System.out.println("Calculate Problem Rate for Facility: " + searchedMaint.calcProblemRateForFacility(p));
        System.out.println("Calculate Down Time for Facility: " + searchedMaint.calcDownTimeForFacility(r));
        System.out.println("List Maint Requests: " + searchedMaint.listMaintRequests());
        System.out.println("List Maintenance: " + searchedMaint.listMaintenance());
        System.out.println("List Facility problems: " + searchedMaint.listFacilityProblems());
        
        
        System.out.println("-------adding new maint obj------");
        
        //create new maintenance object and add to the db
        FacilityMaintenance fm1 = new FacilityMaintenance();
        Request req = new Request();
		Date date3= formatter.parse("2015-12-15");
		Date date4= formatter.parse("2015-12-20");
		
        req.setCompleteDate(date4);
        req.setRequestDate(date3);
        req.setFacility(Facility1);
        
        req.setRequestID(444);
        Problem prob1 = new Problem();
        prob1.setProblem("ac not working");
        prob1.setProblemID(6);
        req.setProblem(prob1);
        fm1.setRequest(req);
        fm1.setRequestID(req.getRequestID());
        Cost cost = new Cost();
        cost.setCost(300);
        cost.setRequestID(4);
        MaintenanceSchedule ms = new MaintenanceSchedule();
        ms.setFacility(Facility1);
        ms.setReserveDate(date1);
        ms.setStatus(true);
        fm1.setFacilityID(9999);
        req.setMaintenanceSchedule(ms);
        fm1.setCost(cost);
      //  fm1.setFacility(Facility1);
        fm1.setRequest(req);
        
        mManager.addMaint(fm1);
       

        //search db for facility use object
        UseManager uManager = new UseManager();
        FacilityUse searchedUse= uManager.findUseById(123);
        System.out.println("Use for facility: " + searchedUse.getFacilityID());
        System.out.println(""
        		+ "Customer ID: " + searchedUse.getCustomerID());
        System.out.println("Start Date: " + searchedUse.getStartDate());
        System.out.println("End Date: " + searchedUse.getEndDate());
        System.out.println("Customer: " + searchedUse.getCustomer().getCustomerID() + " " + searchedUse.getCustomer().getCreditCard());
        System.out.println("Customer info: " + searchedUse.getCustomer().getFirstName()+ " " + searchedUse.getCustomer().getLastName());
        System.out.println(searchedUse.getCustomer().getAddress());
        System.out.println(searchedUse.getCustomer().getPhoneNumber());
        
        System.out.println("\nFacility Use Methods:");
        System.out.println("Facility is in use during interval 2016-02-02 to 2016-02-06: " + searchedUse.isInUseDuringInterval(formatter.parse("2016-02-02"), formatter.parse("2016-02-06)")) );
    	Customer c1 = new Customer();
		c1.setAddress("999 space station");
		c1.setCreditCard("4444666644446666");
		c1.setFirstName("andy");
		c1.setLastName("jones");
		c1.setPhoneNumber("3129999");
		c1.setCustomerID(123);
		c1.setUserID(123);
		Manager m1= new Manager();
		m1.setAddress("123 dirt road");
		m1.setEmployeeID(1);
		m1.setFirstName("Matt");
		m1.setLastName("Poe");
		m1.setPhoneNumber("9998888");
		m1.setSalary(40000.00);
		m1.setUserID(2);
		
		Inspection i1 = new Inspection();
		i1.setManager(m1);
		i1.setReason("routine check");
		Inspection i2 = new Inspection();
		i2.setManager(m1);
		i2.setReason("false alarm");

		List<Inspection> list1 = new ArrayList<Inspection>();
		list1.add(i1);
		list1.add(i2);
		searchedUse.setInspections(list1);
        System.out.println("Assign Facility to Use: " + searchedUse.assignFacilityToUse(Facility1, c1));
        System.out.println("Vacate Facility: " + searchedUse.vacateFacility());
        System.out.println("List Inspections: " + searchedUse.listInspections());
        System.out.println("List Actual Usage: " + searchedUse.listActualUsage());
        System.out.println("Calculate Usage Rate: " + searchedUse.calcUsageRate());
        System.out.println("-------adding new facility use obj------");
        
		//create new use objects to add to db
        
		Date date5 = formatter.parse("2016-01-01");
		Date date6 = formatter.parse("2016-01-03");
		
		FacilityUse use1 = new FacilityUse();
		Customer c2 = new Customer();
		c2.setAddress("123 loyola");
		c2.setCreditCard("1111333355557777");
		c2.setFirstName("jane");
		
		c2.setLastName("apple");
		c2.setPhoneNumber("7777777");
		c2.setCustomerID(333);
		c2.setUserID(333);
		
		//use1.setFacilityID(Facility1.getFacilityID());
		//use1.setCustomerID(c2.getCustomerID());
		use1.setStartDate(date5);
		use1.setEndDate(date6);
		use1.setFacility(Facility1);

		use1.setCustomer(c2);
		UseSchedule usched= new UseSchedule();
		usched.setInUse(true);
		usched.setFacility(Facility1);
		usched.setUseDate(date3);
		use1.setUseSchedule(usched);

		//add new use facility to database
		uManager.addUse(use1);

		
	}
}
