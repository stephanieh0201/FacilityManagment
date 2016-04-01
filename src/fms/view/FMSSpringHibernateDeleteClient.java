package fms.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fms.model.facility.DetailsInterface;
import fms.model.facility.FacilityInterface;
import fms.model.facility.RoomInterface;
import fms.model.maintenance.CostInterface;
import fms.model.maintenance.FacilityMaintenanceInterface;
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

public class FMSSpringHibernateDeleteClient {
	public static void main (String args[]) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
		System.out.println("***************** Application Context instantiated! ******************");

		//Spring to inject the right object implementation in FacilityManager for facility using Setter Injection
		//Also, bootstrapping the FacilityManager instantiation using factory
		FacilityManager facilityManager = (FacilityManager) context.getBean("facilityManager");
		System.out.println("*************** Creating Facility Manager object *************************");
		System.out.println("*************** DELETE EXAMPLE *************************");

		//Find a facility that already exists; 
		FacilityInterface searchedFacility = facilityManager.findFacilityById(333); 
		System.out.println("*************** Facility to be deleted *************************");
		System.out.println("\tName: \t\t\t" + searchedFacility.getFacilityID()  + "\n");
       
        
        System.out.println("*************** Facility to be deleted *************************");
		facilityManager.deleteFacility(searchedFacility);
		System.out.println("*************** Facility deleted *************************");
		

		//Spring to inject the right object implementation in FacilityManager for facility using Setter Injection
		//Also, bootstrapping the FacilityManager instantiation using factory
		//deleting maintenance
		MaintenanceManager maintManager = (MaintenanceManager) context.getBean("maintenanceManager");
		System.out.println("*************** Creating Maintenance Manager object *************************");
		System.out.println("*************** DELETE EXAMPLE *************************");

		//Find a maintenance that already exists; 
		FacilityMaintenanceInterface searchedMaint = maintManager.findMaintenanceById(987); 
		System.out.println("*************** Facility Maintenance to be deleted *************************");
		System.out.println("\tMaintenance ID: \t\t\t" + searchedMaint.getMaintenanceID()  + "\n" 
				+ "\tFacilityID: \t\t\t" +searchedMaint.getFacilityID());
       
        
        System.out.println("*************** Maintenance to be deleted *************************");
		maintManager.deleteMaintenance(searchedMaint);
		
		System.out.println("*************** Maintenance deleted *************************");
		
//deleting use
		UseManager useManager = (UseManager) context.getBean("useManager");
		System.out.println("*************** Creating Use Manager object *************************");
		System.out.println("*************** DELETE EXAMPLE *************************");

		//Find a use that already exists; 
		FacilityUseInterface searchedUse = useManager.findUseById(1111); 
		System.out.println("************** Use to be deleted *************************");
		System.out.println("\tUse ID: \t\t\t" + searchedUse.getUseID());
       
        
        System.out.println("*************** Deleting use *************************");
		useManager.deleteUse(searchedUse);
		
		System.out.println("*************** Use deleted *************************");
		
		CustomerManager customerManager = (CustomerManager) context.getBean("customerManager");
		System.out.println("*************** Creating Customer Manager object *************************");
		System.out.println("*************** DELETE EXAMPLE *************************");

		//Find a facility that already exists; 
		CustomerInterface searchedCustomer = customerManager.findCustomerById(13); 
		System.out.println("*************** Customer to be deleted *************************");
		System.out.println("\tName: \t\t\t" + searchedCustomer.getLastName() +", " +searchedCustomer.getFirstName()  + "\n");
       
        
        System.out.println("*************** Customer to be deleted *************************");
		customerManager.deleteCustomer(searchedCustomer);
		System.out.println("*************** Customer deleted *************************");
		
		
		ManagerManager managerManager = (ManagerManager) context.getBean("managerManager");
		System.out.println("*************** Creating Manager Manager object *************************");
		System.out.println("*************** DELETE EXAMPLE *************************");

		//Find a facility that already exists
		ManagerInterface searchedManager = managerManager.findManagerById(3); 
		System.out.println("*************** Manager to be deleted *************************");
		System.out.println("\tName: \t\t\t" + searchedManager.getLastName() +", " +searchedManager.getFirstName()  + "\n");
       
        
        System.out.println("*************** Manager to be deleted *************************");
		managerManager.deleteManager(searchedManager);
		System.out.println("*************** Manager deleted *************************");
		
		CostManager costManager= (CostManager) context.getBean("costManager");
		CostInterface deleteCost = costManager.findCostById(123);
		costManager.deleteCost(deleteCost);
		
		DetailsManager detailsManager= (DetailsManager) context.getBean("detailsManager");
		DetailsInterface deleteDetail = detailsManager.findDetailsById(9124);
		detailsManager.deleteDetails(deleteDetail);
		
		InspectionManager inspectionManager= (InspectionManager) context.getBean("inspectionManager");
		InspectionInterface deleteInspection = inspectionManager.findInspectionById(584);
		inspectionManager.deleteInspection(deleteInspection);
		
		ProblemManager problemManager = (ProblemManager) context.getBean("problemManager");
		ProblemInterface deleteProblem = problemManager.findProblemById(492);
		problemManager.deleteProblem(deleteProblem);
		
		RequestManager requestManager = (RequestManager) context.getBean("requestManager");
		RequestInterface deleteRequest = requestManager.findRequestById(281);
		requestManager.deleteRequest(deleteRequest);
		
		RoomManager roomManager = (RoomManager) context.getBean("roomManager");
		RoomInterface deleteRoom = roomManager.findRoomById(11111);
		roomManager.deleteRoom(deleteRoom);
		
	}
}
