package fms.view;

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
import fms.model.manager.FacilityManager;
import fms.model.manager.MaintenanceManager;

public class FMSSpringHibernateSearchClient {
	public static void main (String args[]) throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
    /*  System.out.println("***************** Application Context instantiated! ******************");
        //Spring to inject the right object implementation in FacilityManager for facility using Setter Injection
        //Also, bootstrapping the FacilityManager instantiation using factory
        FacilityManager facilityManager = (FacilityManager) context.getBean("facilityManager");
	    System.out.println("*************** Creating Facility Manager object *************************"); 
        System.out.println("*************** SEARCH EXAMPLE *************************");
        //Find a customer if already exists; if not, create a new one.
        FacilityInterface searchedFacility = facilityManager.findFacilityById(2); 
             
        System.out.println("Searched facility information .......>>");
        System.out.println("\tName: \t\t\t\t" + searchedFacility.getFacilityID() + "\n");
        DetailsInterface details = searchedFacility.getDetails();
        System.out.println("\tDetails of facility: \t\t\t\t" +details.toString());
        List <RoomInterface> list =searchedFacility.getRoomsList();
        System.out.println("\tRooms are: ");
        for (RoomInterface r : list) {
        	System.out.println("\tID: \t\t\t\t" + r.getRoomID() + "\n\t-Capacity: \t\t\t\t" + r.getCapacity());
        }*/
		
		//Search for Maintenance Object
		 MaintenanceManager maintManager = (MaintenanceManager) context.getBean("maintenanceManager");
		 System.out.println("*************** Creating Maintenance Manager object *************************"); 
	     System.out.println("*************** SEARCH EXAMPLE *************************");
	        //Find a customer if already exists; if not, create a new one.
	     FacilityMaintenanceInterface searchedMaint = maintManager.findMaintenanceById(1); 
	             
	     System.out.println("Searched maintenance information .......>>");
	     System.out.println("\tMaint ID: \t\t\t" + searchedMaint.getFacilityID() + "\n");
	     CostInterface cost = searchedMaint.getCost();
	     System.out.println("\tCost: \t\t\t\t"+ cost.getMaintenanceCost());
	     List <RequestInterface> list =searchedMaint.getListRequests();
	     System.out.println("\tRequests: " );
	     for (RequestInterface r : list) {
	      	System.out.println("\tID: \t\t\t\t" + r.getRequestID() + "\n\t-Date: \t\t\t\t" + r.getRequestDate());
	      	ProblemInterface prob = r.getProblem();
	      	System.out.println("\tProblem: \t\t\t  " + prob.getProblem());
	      }
	     

	}
}
