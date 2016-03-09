package fms.view;

import fms.model.facility.DetailsInterface;
import fms.model.facility.FacilityInterface;
import fms.model.manager.FacilityManager;

public class FMSClient3 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        System.out.println("***************** Application Context instantiated! ******************");

        //Spring to inject the right object implementation in CustomerService for customer using Setter Injection
        //Also, bootstrapping the CustomerService instantiation using factory
        FacilityManager facilityManager = (FacilityManager) context.getBean("facility");
     
        FacilityInterface facility = facilityManager.getFacility();
		facility.setFacilityID(3);

//		DetailsInterface details = facility.getDetails();
//		details.setAddress(123 ABC Street);
//		details.setInformation("testing building");
//		
        
        //Spring to inject the right object implementation in Customer object for BillingAddress using Setter Injection
//        Address billingAddress = customer.getBillingAddress();
//        
//        billingAddress.setStreet("500 West Madison St.");
//        billingAddress.setUnit("Suite 1000");
//        billingAddress.setCity("Chicago");
//        billingAddress.setState("IL");
//        billingAddress.setZip("66610");	     
		}

}
