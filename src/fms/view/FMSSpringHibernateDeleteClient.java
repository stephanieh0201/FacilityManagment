package fms.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import fms.model.facility.FacilityInterface;
import fms.model.manager.FacilityManager;

public class FMSSpringHibernateDeleteClient {
	public static void main (String args[]) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
		System.out.println("***************** Application Context instantiated! ******************");

		//Spring to inject the right object implementation in CustomerService for customer using Setter Injection
		//Also, bootstrapping the CustomerService instantiation using factory
		FacilityManager facilityManager = (FacilityManager) context.getBean("facilityManager");
		System.out.println("*************** Creating Customer service object *************************"); 
    
		System.out.println("*************** DELETE EXAMPLE *************************");

		//Find a customer if already exists; if not, create a new one.
		FacilityInterface searchedFacility = facilityManager.findFacilityById(3); 
		
		System.out.println("*************** Cutomer to be deleted *************************");
		System.out.println("\tName: \t\t\t" + searchedFacility.getFacilityID()  + "\n");
       /* 
        Address billingAdd = searchedCustomer.getBillingAddress();
        //Address billingAdd = customerService.findCustomerAddress(searchedCustomer.getCustomerId());
        System.out.println("\tBilling Address:\t" + billingAdd.getAddressId() + 
        		"\n\t\t\t\t" + billingAdd.getStreet() +
        		"\n\t\t\t\t" + billingAdd.getUnit() + 
        		"\n\t\t\t\t" + billingAdd.getCity() + ", " + 
        		billingAdd.getState() + " " + billingAdd.getZip() +
        		"\n");
        
        System.out.println("*************** Cutomer to be deleted *************************");*/
		facilityManager.deleteFacility(searchedFacility);
	//	System.out.println("*************** Cutomer deleted *************************");
	}
}
