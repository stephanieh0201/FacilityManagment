package fms.view;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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

public class FMSClient {

	public static void main(String[] args) throws ParseException {
		
        
        //create a new facility 
        Facility Facility1 = new Facility();
        List<RoomInterface> rooms1 = new ArrayList<RoomInterface>();
		Room r1=new Room();
		r1.setCapacity(700);
		r1.setRoomID(100);
		//r1.setFacility(Facility1);
		Room r2=new Room();
		r2.setCapacity(850);
		r2.setRoomID(101);
		//r2.setFacility(Facility1);
		rooms1.add(r1);
		rooms1.add(r2);
		Details detail=new Details();
		detail.setAddress("99 Apple Valley");
		detail.setInformation("office space");
		Facility1.setDetails(detail);
		Facility1.setFacilityID(9999);
		Facility1.setRoomsList(rooms1);
		
		System.out.println("\nFacility Interface Methods:");
        System.out.println("List Facilities: " + Facility1.listFacilities());
        System.out.println("Get Facility Info: " + Facility1.getFacilityInformation());
        System.out.println("Request Available capacity: " + Facility1.requestAvailableCapacity());
        Room roomAdd = new Room();
        roomAdd.setCapacity(300);
      //  roomAdd.setFacility(Facility1);
        roomAdd.setRoomID(3);
        System.out.println("Adding new facility: " + Facility1.addNewFacility(roomAdd));
        Details d = new Details();
        d.setAddress("123 america road");
        d.setInformation("building moved locations");
        System.out.println("Adding facility details." );
        Facility1.addFacilityDetail(d);
        System.out.println("Removing facility: " + Facility1.removeFacility(roomAdd));

		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = formatter.parse("2016-02-22");
		Date date2 = formatter.parse("2016-02-23");
		
        //create new facility maintenance objects
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
        fm1.setFacility(Facility1);
        fm1.setRequest(req);
        System.out.println("\nFacility Maintenance Methods:");
        System.out.println("Schedule Maintenance: " + fm1.scheduleMaintenance(date3, date4) );
        System.out.println("Calculate Maint Cost for Facility: " + fm1.calcMaintenanceCostForFacility(req));
        System.out.println("Calculate Problem Rate for Facility: " + fm1.calcProblemRateForFacility(prob1));
        System.out.println("Calculate Down Time for Facility: " + fm1.calcDownTimeForFacility(req));
        System.out.println("List Maint Requests: " + fm1.listMaintRequests());
        System.out.println("List Maintenance: " + fm1.listMaintenance());
        System.out.println("List Facility problems: " + fm1.listFacilityProblems());
        
        

        
        //create new maintenance object and add to the db
        
       


		Manager m1= new Manager();
		m1.setAddress("123 dirt road");
		m1.setEmployeeID(1);
		m1.setFirstName("Matt");
		m1.setLastName("Poe");
		m1.setPhoneNumber("9998888");
		m1.setSalary(40000.00);
		m1.setUserID(2);
		
		
		
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
		
	
		use1.setStartDate(date5);
		use1.setEndDate(date6);
		use1.setFacility(Facility1);

		use1.setCustomer(c2);
		UseSchedule usched= new UseSchedule();
		usched.setInUse(true);
		usched.setFacility(Facility1);
		usched.setUseDate(date3);
		use1.setUseSchedule(usched);
		Inspection i1 = new Inspection();
		i1.setManager(m1);
		i1.setReason("routine check");
		Inspection i2 = new Inspection();
		i2.setManager(m1);
		i2.setReason("false alarm");

		List<Inspection> list1 = new ArrayList<Inspection>();
		list1.add(i1);
		list1.add(i2);
		use1.setInspections(list1);
        
		System.out.println("\nFacility Use Methods:");
		System.out.println("Assign Facility to Use: " + use1.assignFacilityToUse(Facility1, c2));
        System.out.println("Vacate Facility: " + use1.vacateFacility());
        System.out.println("List Inspections: " +  use1.listInspections());
        System.out.println("List Actual Usage: " + use1.listActualUsage());
        System.out.println("Calculate Usage Rate: " + use1.calcUsageRate());
       

        
		

	

	}
}
