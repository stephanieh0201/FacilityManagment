package fms.view;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import fms.model.facility.Details;
import fms.model.facility.Facility;
import fms.model.facility.Room;
import fms.model.maintenance.FacilityMaintenance;
import fms.model.use.Customer;
import fms.model.use.FacilityUse;

public class FMSClient {

	public static void main(String[] args) throws ParseException {
		System.out.println("creating rooms");
		List<Room> rooms1 = new ArrayList<Room>();
		Room r1=new Room();
		Room r2=new Room();
		r1.setCapacity(1000);
		r1.setRoomID(1);
		r2.setCapacity(300);
		r2.setRoomID(2);
		rooms1.add(r1);
		rooms1.add(r2);
		//rooms1.add(new Room(100, 1));
		//rooms1.add(new Room(50,2));
		//rooms1.add(new Room(120,3));
		//rooms1.add(new Room(15,4));

		List<Room> rooms2 = new ArrayList<Room>();
		Room r3=new Room();
		r3.setCapacity(5000);
		r3.setRoomID(100);
		//rooms2.add(new Room(1000,5));
		//rooms2.add(new Room(2500,6));
		rooms2.add(r3);
		System.out.println("creating facilities with rooms");
		Facility Facility1 = new Facility();
		Details detail1=new Details();
		
		detail1.setAddress("123 Main St");
		detail1.setInformation("business building");
		Facility1.setDetails(detail1);
		
		Facility1.setFacilityID(23);
	//	Facility1.setFacilityInformation("business building");
		Facility1.setRooms(rooms1);
		Facility Facility2 = new Facility();
		Facility2.setFacilityID(55);
	//	Facility2.setFacilityInformation("large rooms");
		Facility2.setRooms(rooms2);
		System.out.println("listing facilities");
		System.out.println(Facility1.listFacilities());
		System.out.println(Facility2.listFacilities());
		for (Facility f : Facility1.listFacilities()) {
			System.out.println(f.getFacilityID());
		}
		System.out.println("request capacity of facility2");
		System.out.println(Facility2.requestAvailableCapacity());
		System.out.println("get rooms of facility 1");
		List<Room> room3 = Facility1.getRooms();
		for (Room r : room3) {
			System.out.println(r.getRoomID());
		}
		System.out.println("creating a customer");
		Customer c1=new Customer();
		c1.setAddress("123 Main Street, Chicago, IL");
		c1.setCreditCard("1111222233334444");
		c1.setCustomerID(1);
		c1.setFirstName("Bob");
		c1.setLastName("Doe");
		c1.setPhoneNumber("3121234567");
		System.out.println("Assigning customer to facility");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = formatter.parse("2016-01-01");
		Date date2 = formatter.parse("2016-01-03");
		
		FacilityUse use1 = new FacilityUse(Facility1, date1, date2);
		
		
		use1.assignFacilityToUse(Facility1, c1);
		
		System.out.println(Facility1.getUser().getCustomerID());
		System.out.println("Usage: " + use1.listActualUsage());
		System.out.println("Rate: " + use1.calcUsageRate());
		
		FacilityMaintenance maint1 = new FacilityMaintenance();
		//maint1.makeFacilityMaintRequest(request);
		System.out.println("get facility 1 info");
		System.out.println(Facility1.getFacilityInformation());
		Room r5= new Room();
		r5.setCapacity(700);
		r5.setRoomID(12);
		Facility1.addNewFacility(r5);
		Details det = new Details();
		det.setAddress("12345 Hello World");
		det.setInformation("building moved");
		Facility1.addFacilityDetail(det);
		System.out.println(Facility1.getFacilityInformation());
		Facility1.removeFacility(r3);
		List<Room> room4 = Facility1.getRooms();
		for (Room r : room4) {
			System.out.println(r.getRoomID());
		}
	}

}
