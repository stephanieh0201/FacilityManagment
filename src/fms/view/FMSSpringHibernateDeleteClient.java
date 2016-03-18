package fms.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import fms.model.facility.FacilityInterface;
import fms.model.maintenance.FacilityMaintenanceInterface;
import fms.model.manager.FacilityManager;
import fms.model.manager.MaintenanceManager;

public class FMSSpringHibernateDeleteClient {
	public static void main (String args[]) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
		System.out.println("***************** Application Context instantiated! ******************");

		//Spring to inject the right object implementation in FacilityManager for facility using Setter Injection
		//Also, bootstrapping the FacilityManager instantiation using factory
		/*FacilityManager facilityManager = (FacilityManager) context.getBean("facilityManager");
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
		*/
		MaintenanceManager maintManager = (MaintenanceManager) context.getBean("maintenanceManager");
		System.out.println("*************** Creating Maintenance Manager object *************************");
		System.out.println("*************** DELETE EXAMPLE *************************");

		//Find a facility that already exists; 
		FacilityMaintenanceInterface searchedMaint = maintManager.findMaintenanceById(987); 
		System.out.println("*************** Facility Maintenance to be deleted *************************");
		System.out.println("\tMaintenance ID: \t\t\t" + searchedMaint.getMaintenanceID()  + "\n" 
				+ "\tFacilityID: \t\t\t" +searchedMaint.getFacilityID());
       
        
        System.out.println("*************** Maintenance to be deleted *************************");
		maintManager.deleteMaintenance(searchedMaint);
		
		System.out.println("*************** Maintenance deleted *************************");
	}
}
