package fms.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import fms.dao.HibernateMySQLHelper;
import fms.model.facility.DetailsInterface;
import fms.model.facility.FacilityInterface;
import fms.model.facility.RoomInterface;
import fms.model.maintenance.CostInterface;
import fms.model.maintenance.FacilityMaintenanceInterface;
import fms.model.maintenance.ProblemInterface;
import fms.model.maintenance.RequestInterface;
import fms.model.manager.CustomerManager;
import fms.model.manager.FacilityManager;
import fms.model.manager.MaintenanceManager;
import fms.model.manager.UseManager;
import fms.model.use.Customer;
import fms.model.use.CustomerInterface;
import fms.model.use.FacilityUseInterface;
import fms.model.use.InspectionInterface;
import fms.model.use.ManagerInterface;
import fms.model.use.UserInterface;

public class FMSSpringHibernateInsertClient {
	public static void main (String args[]) throws Exception {
		//Insert Facility Example
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
		DetailsInterface details = (DetailsInterface) context.getBean("details");
		details.setAddress("999 Lakeshore Dr");
		details.setInformation("Loyola Building");
		details.setFacilityID(333);
		facility.setDetails(details);
    
        System.out.println("*************** Saving Facility ***********************");
        facilityManager.addFacility(facility);
        System.out.println("*************** Facility Inserted *************************");
		

       // System.out.println("***************** Application Context instantiated! ******************");
        MaintenanceManager maintManager = (MaintenanceManager) context.getBean("maintenanceManager");
        
        System.out.println("*************** INSERT EXAMPLE *************************");
        System.out.println("*************** This example involves Instantiating and Saving FacilityMaintenance ***********************");
        
        System.out.println("*************** Instantiating FacilityMaintenance ***********************");
        
        FacilityMaintenanceInterface facilityMaint = (FacilityMaintenanceInterface) context.getBean("facilityMaintenance");
		facilityMaint.setFacilityID(12345);
		facilityMaint.setMaintenanceID(987);

		CostInterface cost = (CostInterface) context.getBean("cost");
		cost.setMaintenanceCost(500);
		cost.setMaintenanceID(987);
		facilityMaint.setCost(cost);
		RequestInterface request = (RequestInterface) context.getBean("request");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = formatter.parse("2016-03-17");
		Date date2 = formatter.parse("2016-03-23");
		request.setRequestDate(date1);
		request.setCompleteDate(date2);
		request.setProblemID(1);
		request.setRequestID(555);

		ProblemInterface problem = (ProblemInterface) context.getBean("problem");
		problem.setProblem("testing");
		problem.setProblemID(1);
		problem.setRequestID(555);
		request.setProblem(problem);
		facilityMaint.addRequest(request);

		
		
		//System.out.println("Facility Details: " + facility.getDetails());
		///        
        System.out.println("*************** Saving Maintenance ***********************");
        maintManager.addMaintenance(facilityMaint);
        System.out.println("*************** Maintenance Inserted *************************");
        
        System.out.println("***************** Application Context instantiated! ******************");
        UseManager useManager = (UseManager) context.getBean("useManager");

        System.out.println("*************** INSERT EXAMPLE *************************");
        System.out.println("*************** This example involves Instantiating and Saving FacilityUse ***********************");
        
        System.out.println("*************** Instantiating FacilityUse ***********************");
        
        FacilityUseInterface facilityUse = (FacilityUseInterface) context.getBean("facilityUse");
		facilityUse.setUseID(1111);
		facilityUse.setFacilityID(2);
		Date date3 = formatter.parse("2016-03-21");
		Date date4 = formatter.parse("2016-03-26");
		facilityUse.setStartDate(date3);
		facilityUse.setEndDate(date4);
		
		CustomerInterface customer = (CustomerInterface) context.getBean("customer");
		customer.setUseID(1111);
		customer.setCreditCard("1111999911119999");
		customer.setCustomerID(13);
		customer.setAddress("999 Maple Street");
		customer.setFirstName("Larry");
		customer.setLastName("Smith");
		customer.setPhoneNumber("1234567");
		
		facilityUse.setCustomer(customer);
		facilityUse.setCustomerID(customer.getCustomerID());
		InspectionInterface inspection1 = (InspectionInterface) context.getBean("inspection");
		inspection1.setInspectionID(100);
		inspection1.setReason("testing");
		inspection1.setUseID(1111);
		ManagerInterface manager1 = (ManagerInterface) context.getBean("manager");
		manager1.setEmployeeID(3);
		manager1.setSalary(70000);
		manager1.setInspectionID(100);
		manager1.setAddress("111 test");
		manager1.setFirstName("Bob");
		manager1.setLastName("Ford");
		manager1.setPhoneNumber("9998888");

		inspection1.setManager(manager1);
		InspectionInterface inspection2 = (InspectionInterface) context.getBean("inspection");
		inspection2.setInspectionID(101);
		inspection2.setReason("second inspection");
		inspection2.setUseID(1111);
		ManagerInterface manager2 = (ManagerInterface) context.getBean("manager");
		manager2.setEmployeeID(9991);
		manager2.setSalary(27000);
		manager2.setInspectionID(101);
		manager2.setAddress("764 America");
		manager2.setFirstName("Jane");
		manager2.setLastName("Paul");
		manager2.setPhoneNumber("7777777");

		
		inspection2.setManager(manager2);
		facilityUse.addInspection(inspection1);
		facilityUse.addInspection(inspection2);

		
		
		//System.out.println("Facility Details: " + facility.getDetails());
		///        
        System.out.println("*************** Saving Use ***********************");
        useManager.addUse(facilityUse);
        System.out.println("*************** Use Inserted *************************");
        
      /*  CustomerManager customerManager = (CustomerManager) context.getBean("customerManager");
        
        System.out.println("*************** INSERT EXAMPLE *************************");
        System.out.println("*************** This example involves Instantiating and Saving Customer ***********************");
        CustomerInterface customer = (CustomerInterface) context.getBean("customer");
        System.out.println("*************** Instantiating Customer ***********************");
		customer.setUseID(1111);
		customer.setCreditCard("1111999911119999");
		customer.setCustomerID(13);
		customer.setAddress("999 Maple Street");
		customer.setFirstName("Larry");
		customer.setLastName("Smith");
		customer.setPhoneNumber("1234567");
    
        System.out.println("*************** Saving Customer ***********************");
        customerManager.addCustomer(customer);
        System.out.println("*************** Customer Inserted *************************");*/
		
  

	}
}
