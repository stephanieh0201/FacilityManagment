package fms.view;
import java.util.ArrayList;
import java.util.List;

import fms.model.facility.Facility;
import fms.model.facility.Room;

public class FMSClient {

	public static void main(String[] args) {
		System.out.println("creating rooms");
		List<Room> rooms1 = new ArrayList<Room>();
		rooms1.add(new Room(100, 1));
		rooms1.add(new Room(50,2));
		rooms1.add(new Room(120,3));
		rooms1.add(new Room(15,4));

		List<Room> rooms2 = new ArrayList<Room>();
		rooms2.add(new Room(1000,5));
		rooms2.add(new Room(2500,6));
		System.out.println("creating facilities with rooms");
		Facility Facility1 = new Facility();
		Facility1.setFacilityID(23);
		Facility1.setFacilityInformation("business building");
		Facility1.setRooms(rooms1);
		Facility Facility2 = new Facility();
		Facility2.setFacilityID(55);
		Facility2.setFacilityInformation("large rooms");
		Facility2.setRooms(rooms2);
		System.out.println("listing facilities");
		Facility1.listFacilities();
		System.out.println("request capacity of facility2");
		System.out.println(Facility2.requestAvailableCapacity());
		System.out.println("get rooms of facility 1");
		List<Room> room3 = Facility1.getRooms();
		for (Room r : room3) {
			System.out.println(r.getRoomID());
		}
		System.out.println("get facility 2 info");
		System.out.println(Facility2.getFacilityInformation());
	}

}
