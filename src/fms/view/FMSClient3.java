package fms.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fms.model.facility.DetailsInterface;
import fms.model.facility.FacilityInterface;
import fms.model.facility.RoomInterface;
import fms.model.maintenance.CostInterface;
import fms.model.maintenance.FacilityMaintenanceInterface;
import fms.model.maintenance.MaintenanceScheduleInterface;
import fms.model.maintenance.ProblemInterface;
import fms.model.maintenance.RequestInterface;
import fms.model.manager.FacilityManager;
import fms.model.manager.MaintenanceManager;
import fms.model.manager.UseManager;
import fms.model.use.CustomerInterface;
import fms.model.use.FacilityUseInterface;
import fms.model.use.InspectionInterface;
import fms.model.use.ManagerInterface;
import fms.model.use.UseScheduleInterface;

public class FMSClient3 {

	public static void main(String[] args) throws ParseException {
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
		
		//Spring to inject object implementation in Maintenance objects 
		MaintenanceManager maintenanceManager = (MaintenanceManager) context.getBean("maintenanceManager");
		FacilityMaintenanceInterface maintenance = maintenanceManager.getFacilityMaintenance();
		maintenance.setFacilityID(3);
		maintenance.setFacility(facility);		
		CostInterface cost = (CostInterface) context.getBean("cost");
		cost.setCost(350);
		cost.setRequestID(1);
		RequestInterface request = (RequestInterface) context.getBean("request");
		request.setRequestID(1);
		request.setFacility(facility);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = formatter.parse("2016-02-22");
		Date date2 = formatter.parse("2016-02-23");
		request.setRequestDate(date1);
		request.setCompleteDate(date2);
		
		MaintenanceScheduleInterface schedule = (MaintenanceScheduleInterface) context.getBean("maintenanceSchedule");
		schedule.setFacility(facility);
		schedule.setReserveDate(date1);
		schedule.setStatus(true);
		request.setMaintenanceSchedule(schedule);
		ProblemInterface problem = (ProblemInterface) context.getBean("problem");
		problem.setProblem("plumbing");
		problem.setProblemID(1);
		request.setProblem(problem);
		request.setProblemID(1);
		maintenance.addRequest(request);
		System.out.println("maintenance down time " + maintenance.calcDownTimeForFacility(request));
		System.out.println("facility problems " + maintenance.listFacilityProblems());
		System.out.println("facility maintenance: "+ maintenance.getRequest());
		
		//Spring to inject dependencies for facility use
		UseManager useManager = (UseManager) context.getBean("useManager");
		FacilityUseInterface use = useManager.getFacilityUse();
		Date date3 = formatter.parse("2016-03-03");
		Date date4 = formatter.parse("2016-03-10");
		use.setStartDate(date3);
		use.setEndDate(date4);
		use.setFacility(facility);
		use.setFacilityID(3);
		CustomerInterface customer = (CustomerInterface) context.getBean("customer");
		InspectionInterface inspection = (InspectionInterface) context.getBean("inspection");
		UseScheduleInterface useSchedule = (UseScheduleInterface) context.getBean("useSchedule");
		ManagerInterface manager = (ManagerInterface) context.getBean("manager");
		customer.setCreditCard("1111222233334444");
		customer.setCustomerID(4);
		manager.setEmployeeID(99999);
		manager.setSalary(70000);
		inspection.setManager(manager);
		inspection.setReason("routine");
		use.setInspections(inspection);
		use.setCustomer(customer);
		useSchedule.setFacility(facility);
		useSchedule.setInUse(true);
		useSchedule.setUseDate(date3);
		use.setUseSchedule(useSchedule);
		System.out.println("Use customer " + use.getCustomer());
		System.out.println("Use " + use.getUseSchedule());
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
