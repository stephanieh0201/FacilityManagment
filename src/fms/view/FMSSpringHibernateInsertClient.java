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
import fms.model.manager.CostManager;
import fms.model.manager.CustomerManager;
import fms.model.manager.DetailsManager;
import fms.model.manager.FacilityManager;
import fms.model.manager.InspectionManager;
import fms.model.manager.MaintenanceManager;
import fms.model.manager.ProblemManager;
import fms.model.manager.RequestManager;
import fms.model.manager.RoomManager;
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
		customer.setCreditCard("1234432112344321");
		customer.setCustomerID(483);
		customer.setAddress("329 Netherlands");
		customer.setFirstName("Annie");
		customer.setLastName("Apple");
		customer.setPhoneNumber("8274921");
		
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
        
        CustomerManager customerManager = (CustomerManager) context.getBean("customerManager");
        
        System.out.println("*************** INSERT EXAMPLE *************************");
        System.out.println("*************** This example involves Instantiating and Saving Customer ***********************");
        CustomerInterface insertCustomer = (CustomerInterface) context.getBean("customer");
        System.out.println("*************** Instantiating Customer ***********************");
		insertCustomer.setUseID(1111);
		insertCustomer.setCreditCard("1111999911119999");
		insertCustomer.setCustomerID(13);
		insertCustomer.setAddress("999 Maple Street");
		insertCustomer.setFirstName("Larry");
		insertCustomer.setLastName("Smith");
		insertCustomer.setPhoneNumber("1234567");
    
        System.out.println("*************** Saving Customer ***********************");
        customerManager.addCustomer(insertCustomer);
        System.out.println("*************** Customer Inserted *************************");
		
        CostManager costManager = (CostManager) context.getBean("costManager");
        CostInterface insertCost = (CostInterface) context.getBean("cost");
        insertCost.setMaintenanceCost(9999);
        insertCost.setMaintenanceID(123);
        System.out.println("*************** Saving Cost ***********************");
        costManager.addCost(insertCost);
        System.out.println("*************** Cost Inserted *************************");

        DetailsManager detailsManager = (DetailsManager) context.getBean("detailsManager");
        DetailsInterface insertDetail= (DetailsInterface) context.getBean("details");
        insertDetail.setAddress("888 Forest Lane");
        insertDetail.setDetailsID(74800);
        insertDetail.setFacilityID(9124);
        insertDetail.setInformation("medical building");
        System.out.println("*************** Saving Details ***********************");
        detailsManager.addDetails(insertDetail);
        System.out.println("*************** Details Inserted *************************");
        
        InspectionManager inspectionManager = (InspectionManager) context.getBean("inspectionManager");
        InspectionInterface insertInspection = (InspectionInterface) context.getBean("inspection");
        insertInspection.setInspectionID(584);
        insertInspection.setReason("weekly clean up");
        insertInspection.setUseID(56);
        ManagerInterface managerInsp= (ManagerInterface) context.getBean("manager");
        managerInsp.setAddress("123 abc");
        managerInsp.setEmployeeID(84921);
        managerInsp.setFirstName("Andrew");
        managerInsp.setLastName("Johnson");
        managerInsp.setInspectionID(584);
        managerInsp.setPhoneNumber("321232");
        managerInsp.setSalary(48000);
        insertInspection.setManager(managerInsp);
        inspectionManager.addInspection(insertInspection);
        
        
        ProblemManager problemManager = (ProblemManager) context.getBean("problemManager");
        ProblemInterface insertProb = (ProblemInterface) context.getBean("problem");
        insertProb.setProblem("internet service");
        insertProb.setProblemID(492);
        problemManager.addProblem(insertProb);
        
        
		Date date8 = formatter.parse("2016-04-01");
		Date date9 = formatter.parse("2016-04-03");
		
		
        RequestManager requestManager = (RequestManager) context.getBean("requestManager");
        RequestInterface insertReq = (RequestInterface) context.getBean("request");
        insertReq.setRequestDate(date8);
        insertReq.setCompleteDate(date9);
        insertReq.setRequestID(281);
        ProblemInterface reqProb = (ProblemInterface) context.getBean("problem");
        reqProb.setProblem("routine maintenance");
        reqProb.setProblemID(155);
        reqProb.setRequestID(281);
        insertReq.setProblem(reqProb);
        requestManager.addRequest(insertReq);
        
        RoomManager roomManager = (RoomManager) context.getBean("roomManager");
        RoomInterface insertRoom = (RoomInterface) context.getBean("room");
        insertRoom.setCapacity(4000);
        insertRoom.setFacilityID(828);
        insertRoom.setRoomID(11111);
        roomManager.addRoom(insertRoom);
        
	}
}
