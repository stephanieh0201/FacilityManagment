package fms.view;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fms.model.facility.DetailsInterface;
import fms.model.facility.FacilityInterface;
import fms.model.facility.RoomInterface;
import fms.model.manager.FacilityManager;

public class FMSClient3 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        System.out.println("***************** Application Context instantiated! ******************");

        //Spring to inject the right object implementation in Facility Management for facility using Setter Injection
        //Also, bootstrapping the FacilityManager instantiation using factory
        FacilityManager facilityManager = (FacilityManager) context.getBean("facilityManager");
     
        FacilityInterface facility = facilityManager.getFacility();
		facility.setFacilityID(3);
		RoomInterface room = (RoomInterface) context.getBean("room");
		room.setCapacity(1000);
		room.setRoomID(82);
		facility.addRoom(room);
		
		
		
		System.out.println("Facility is " + facility.getFacilityID());
		System.out.println("Facility rooms are " + facility.listFacilities());
		DetailsInterface details = (DetailsInterface) context.getBean("details");
		details.setAddress("123 ABC Street");
		details.setInformation("testing building");
		facility.setDetails(details);
		System.out.println("Facility Details: " + facility.getDetails());
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
