package fms.view;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import fms.model.facility.DetailsInterface;
import fms.model.facility.FacilityInterface;
import fms.model.facility.RoomInterface;
import fms.model.maintenance.CostInterface;
import fms.model.maintenance.FacilityMaintenanceInterface;
import fms.model.maintenance.Problem;
import fms.model.maintenance.ProblemInterface;
import fms.model.maintenance.RequestInterface;
import fms.model.manager.CostManager;
import fms.model.manager.CustomerManager;
import fms.model.manager.DetailsManager;
import fms.model.manager.FacilityManager;
import fms.model.manager.InspectionManager;
import fms.model.manager.MaintenanceManager;
import fms.model.manager.ManagerManager;
import fms.model.manager.ProblemManager;
import fms.model.manager.RequestManager;
import fms.model.manager.RoomManager;
import fms.model.manager.UseManager;
import fms.model.use.CustomerInterface;
import fms.model.use.FacilityUseInterface;
import fms.model.use.InspectionInterface;
import fms.model.use.ManagerInterface;

public class FMSSpringHibernateSearchClient {
	public static void main (String args[]) throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        System.out.println("***************** Application Context instantiated! ******************");
        //Spring to inject the right object implementation in FacilityManager for facility using Setter Injection
        //Also, bootstrapping the FacilityManager instantiation using factory
        FacilityManager facilityManager = (FacilityManager) context.getBean("facilityManager");
	    System.out.println("*************** Creating Facility Manager object *************************"); 
        System.out.println("*************** SEARCH EXAMPLE *************************");
        //Find a customer if already exists; if not, create a new one.
        FacilityInterface searchedFacility = facilityManager.findFacilityById(333); 
             
        System.out.println("Searched facility information .......>>");
        System.out.println("\tName: \t\t\t\t" + searchedFacility.getFacilityID() + "\n");
        DetailsInterface details = searchedFacility.getDetails();
        System.out.println("\tDetails of facility: \t\t\t\t" +details.toString());
        List <RoomInterface> list =searchedFacility.getRoomsList();
        System.out.println("\tRooms are: ");
        for (RoomInterface r : list) {
        	System.out.println("\tID: \t\t\t\t" + r.getRoomID() + "\n\t-Capacity: \t\t\t\t" + r.getCapacity());
        }
		
		//Search for Maintenance Object
		 MaintenanceManager maintManager = (MaintenanceManager) context.getBean("maintenanceManager");
		 System.out.println("*************** Creating Maintenance Manager object *************************"); 
	     System.out.println("*************** SEARCH EXAMPLE *************************");
	        //Find a customer if already exists; if not, create a new one.
	     FacilityMaintenanceInterface searchedMaint = maintManager.findMaintenanceById(987); 
	             
	     System.out.println("Searched maintenance information .......>>");
	     System.out.println("\tMaint ID: \t\t\t" + searchedMaint.getFacilityID() + "\n");
	     CostInterface cost = searchedMaint.getCost();
	     System.out.println("\tCost: \t\t\t\t"+ cost.getMaintenanceCost());
	     List <RequestInterface> requestList =searchedMaint.getListRequests();
	     System.out.println("\tRequests: " );
	     for (RequestInterface r : requestList) {
	      	System.out.println("\tID: \t\t\t\t" + r.getRequestID() + "\n\t-Date: \t\t\t\t" + r.getRequestDate());
	      	ProblemInterface prob = r.getProblem();
	      	System.out.println("\tProblem: \t\t\t  " + prob.getProblem());
	      }
	     //search use
	     UseManager useManager = (UseManager) context.getBean("useManager");
		 System.out.println("*************** Creating Use Manager object *************************"); 
	     System.out.println("*************** SEARCH EXAMPLE *************************");
	        //Find a customer if already exists; if not, create a new one.
	     FacilityUseInterface searchedUse = useManager.findUseById(1111); 
	             
	     System.out.println("Searched use information .......>>");
	     System.out.println("\tMaint ID: \t\t\t" + searchedUse.getFacilityID() + "\n");
	     Date start = searchedUse.getStartDate();
	     Date end = searchedUse.getEndDate();
	     System.out.println("\tStart Date: \t\t\t\t"+ start);
	     System.out.println("\tEnd Date: \t\t\t\t"+ end);
	     
	     List <InspectionInterface> inspectionList =searchedUse.getInspections();
	     System.out.println("\tInspections: " );
	     for (InspectionInterface i : inspectionList) {
	      	System.out.println("\tID: \t\t\t\t" + i.getInspectionID() + "\n\t-Reason: \t\t\t\t" + i.getReason());
	      		ManagerInterface manager = i.getManager();
	      		System.out.println("\tManager: \t\t\t  " + manager.getEmployeeID() + " Salary: " + manager.getSalary());
	      }
	     CustomerInterface customer = searchedUse.getCustomer();
	     System.out.println("Customer ID: " + customer.getCustomerID() + " Payment Credit Card: " + customer.getCreditCard());
        
        
         CustomerManager customerManager = (CustomerManager) context.getBean("customerManager");
		 System.out.println("*************** Creating Use Manager object *************************"); 
	     System.out.println("*************** SEARCH EXAMPLE *************************");
	        //Find a customer if already exists; if not, create a new one.
	     CustomerInterface searchedCust = customerManager.findCustomerByLastName("Smith"); 
	             
	     System.out.println("Searched use information .......>>");
	     System.out.println("\tCustomer ID: \t\t\t" + searchedCust.getCustomerID());
	     System.out.println("\tName: \t\t\t\t"+ searchedCust.getLastName()+", " + searchedCust.getFirstName());
	     System.out.println("\tAddress: \t\t\t"+ searchedCust.getAddress());
	     System.out.println("\tPhone Number: \t\t\t"+ searchedCust.getPhoneNumber());
	     System.out.println("\tCredit Card: \t\t\t"+ searchedCust.getCreditCard());
	     
		 ManagerManager managerManager = (ManagerManager) context.getBean("managerManager");
		 ManagerInterface searchedManag = managerManager.findManagerById(9991);       
	     System.out.println("Searched manager information .......>>");
	     System.out.println("\tManager ID: \t\t\t" + searchedManag.getEmployeeID());
	  
	     System.out.println("\tName: \t\t\t\t"+ searchedManag.getLastName()+", " + searchedManag.getFirstName());
	     System.out.println("\tAddress: \t\t\t"+ searchedManag.getAddress());
	     System.out.println("\tPhone Number: \t\t\t"+ searchedManag.getPhoneNumber());
	     System.out.println("\tSalary: \t\t\t"+ searchedManag.getSalary());
		 
	     CostManager costManager = (CostManager) context.getBean("costManager");
	     CostInterface searchedCost = costManager.findCostById(987);
	     System.out.println("Searched cost information");
	     System.out.println("\tID: \t\t\t" + searchedCost.getMaintenanceID());
	     System.out.println("\tCost: \t\t\t" + searchedCost.getMaintenanceCost());
	     
	     DetailsManager detailsManager = (DetailsManager) context.getBean("detailsManager");
	     DetailsInterface searchedDetails = detailsManager.findDetailsById(9124);
	     System.out.println("Searched details information");
	     System.out.println("\tFacility ID: \t\t" + searchedDetails.getFacilityID());
	     System.out.println("\tAddress: \t\t" + searchedDetails.getAddress());
	     System.out.println("\tInfo: \t\t\t" + searchedDetails.getInformation());
	     
	     InspectionManager inspectionManager = (InspectionManager) context.getBean("inspectionManager");
	     InspectionInterface searchedInspection = inspectionManager.findInspectionById(100);
	     ManagerInterface manager= searchedInspection.getManager();
	     System.out.println("Searched inspection information");
	     System.out.println("\tInspection ID: \t\t" + searchedInspection.getInspectionID());
	     System.out.println("\tReason: \t\t" + searchedInspection.getReason());
	     System.out.println("\tManager ID: \t\t" + manager.getEmployeeID());
	     
	     ProblemManager problemManager = (ProblemManager) context.getBean("problemManager");
	     ProblemInterface searchedProblem = problemManager.findProblemById(1);
	     System.out.println("Searched problem information");
	     System.out.println("\tProblem ID: \t\t" + searchedProblem.getProblemID());
	     System.out.println("\tProblem: \t\t" + searchedProblem.getProblem());

	     RequestManager requestManager = (RequestManager) context.getBean("requestManager");
	     RequestInterface searchedRequest = requestManager.findRequestById(555);
	     System.out.println("Searched request information");
	     System.out.println("\tRequest ID: \t\t" + searchedRequest.getRequestID());
	     System.out.println("\tDate: \t\t" + searchedRequest.getRequestDate());
	     System.out.println("\tComplete Date: \t\t" + searchedRequest.getCompleteDate());
	     
	     RoomManager roomManager = (RoomManager) context.getBean("roomManager");
	     RoomInterface searchedRoom = roomManager.findRoomById(12);
	     System.out.println("Searched room information");
	     System.out.println("\tRoom ID: \t\t" + searchedRoom.getRoomID());
	     System.out.println("\tCapacity: \t\t" + searchedRoom.getCapacity());
	}
}
