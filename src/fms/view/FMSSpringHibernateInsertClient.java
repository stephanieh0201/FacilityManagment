package fms.view;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import fms.dao.HibernateMySQLHelper;
import fms.model.facility.DetailsInterface;
import fms.model.facility.FacilityInterface;
import fms.model.facility.RoomInterface;
import fms.model.manager.FacilityManager;

public class FMSSpringHibernateInsertClient {
	public static void main (String args[]) throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        System.out.println("***************** Application Context instantiated! ******************");
        FacilityManager facilityManager = (FacilityManager) context.getBean("facilityManager");
        
        System.out.println("*************** INSERT EXAMPLE *************************");
        System.out.println("*************** This example involves Instantiating and Saving Facility ***********************");
        
        System.out.println("*************** Instantiating Facility ***********************");
        
        FacilityInterface facility = (FacilityInterface) context.getBean("facility");
		facility.setFacilityID(333);
		RoomInterface room = (RoomInterface) context.getBean("room");
		room.setCapacity(1000);
		room.setRoomID(12);
		
		
	
		room.setFacilityID(facility.getFacilityID());
		facility.addRoom(room);	
		RoomInterface room2 = (RoomInterface) context.getBean("room");
		room2.setCapacity(888);
		room2.setRoomID(100);
		room2.setFacilityID(facility.getFacilityID());
		facility.addRoom(room2);
		//System.out.println("Facility is " + facility.getFacilityID());
		//System.out.println("Facility rooms are " + facility.listFacilities());
		DetailsInterface details = (DetailsInterface) context.getBean("details");
		details.setAddress("123 ABC Street");
		details.setInformation("testing building");
		details.setFacilityID(333);
		facility.setDetails(details);
		//System.out.println("Facility Details: " + facility.getDetails());
		///
		/*
        
        Customer customer = (Customer) context.getBean("customer");
		customer.setFirstName("Berhane");
        
.setLastName("Zewdie");
        customer.setCustomerId("XYZ123");
        
        //Spring to inject the right object implementation in Customer object for BillingAddress using Setter Injection
        Address billingAddress = customer.getBillingAddress();
        billingAddress.setCustomerId(customer.getCustomerId());
        billingAddress.setAddressId("ADD123");
        billingAddress.setStreet("1 Loyola St.");
        billingAddress.setUnit("Suite 306");
        billingAddress.setCity("Chicago");
        billingAddress.setState("IL");
        billingAddress.setZip("60610");	*/
        
        System.out.println("*************** Saving Facility ***********************");
        facilityManager.addFacility(facility);
        System.out.println("*************** Facility Inserted *************************");
	}
}
