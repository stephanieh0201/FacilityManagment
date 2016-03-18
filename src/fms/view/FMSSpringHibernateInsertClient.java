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
import fms.model.manager.FacilityManager;
import fms.model.manager.MaintenanceManager;

public class FMSSpringHibernateInsertClient {
	public static void main (String args[]) throws Exception {
		//Insert Facility Example
	/*	ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
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
        System.out.println("*************** Saving Facility ***********************");
        facilityManager.addFacility(facility);
        System.out.println("*************** Facility Inserted *************************");*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        System.out.println("***************** Application Context instantiated! ******************");
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
		request.setProblem(problem);
		request.setProblemID(problem.getProblemID());
		facilityMaint.addRequest(request);

		
		
		//System.out.println("Facility Details: " + facility.getDetails());
		///        
        System.out.println("*************** Saving Maintenance ***********************");
        maintManager.addMaintenance(facilityMaint);
        System.out.println("*************** Facility Inserted *************************");
	}
}
