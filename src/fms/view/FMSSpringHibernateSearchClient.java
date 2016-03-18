package fms.view;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import fms.model.facility.DetailsInterface;
import fms.model.facility.FacilityInterface;
import fms.model.facility.RoomInterface;
import fms.model.manager.FacilityManager;

public class FMSSpringHibernateSearchClient {
	public static void main (String args[]) throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        System.out.println("***************** Application Context instantiated! ******************");

        //Spring to inject the right object implementation in CustomerService for customer using Setter Injection
        //Also, bootstrapping the CustomerService instantiation using factory
        FacilityManager facilityManager = (FacilityManager) context.getBean("facilityManager");
	    System.out.println("*************** Creating Facility Manager object *************************"); 
	    
        System.out.println("*************** SEARCH EXAMPLE *************************");
 
        //Find a customer if already exists; if not, create a new one.
        FacilityInterface searchedFacility = facilityManager.findFacilityById(1838); 
             
        System.out.println("Searched facility information .......>>");
        System.out.println("\tName: \t\t\t" + searchedFacility.getFacilityID() + "\n");
        DetailsInterface details = searchedFacility.getDetails();
        System.out.println("Details of facility: " +details.toString());
        List <RoomInterface> list =searchedFacility.getRoomsList();
        System.out.println("Rooms are : ");
        for (RoomInterface r : list) {
        	System.out.println("ID :" + r.getRoomID() + "\nCapacity: " + r.getCapacity());
        }
        /*Address billingAdd = searchedFacility.getBillingAddress();
        //Address billingAdd = customerService.findCustomerAddress(searchedCustomer.getCustomerId());
        System.out.println("\tBilling Address:\t" + billingAdd.getAddressId() + 
        		"\n\t\t\t\t" + billingAdd.getStreet() +
        		"\n\t\t\t\t" + billingAdd.getUnit() + 
        		"\n\t\t\t\t" + billingAdd.getCity() + ", " + 
        		billingAdd.getState() + " " + billingAdd.getZip() +
        		"\n");*/
	}
}
