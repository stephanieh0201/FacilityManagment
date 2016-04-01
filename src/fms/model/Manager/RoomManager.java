package fms.model.manager;

import fms.dao.RoomHibernateDAO;
import fms.model.facility.RoomInterface;

public class RoomManager {

private RoomHibernateDAO roomDAO = new RoomHibernateDAO();
	
	public void addRoom(RoomInterface room) {
		try {
			roomDAO.addRoom(room);
	    } catch (Exception se) {
	      System.err.println("RoomManager: Threw a Exception adding room.");
	      System.err.println(se.getMessage());
	    }
	}
	
	public RoomInterface findRoomById(int maintenanceId) {
		try {
			RoomInterface room = roomDAO.retrieveRoom(maintenanceId);
	    	return room;
	    } catch (Exception se) {
	      System.err.println("RoomManager: Threw a Exception retrieving room.");
	      System.err.println(se.getMessage());
	    }
		return null;
	}
	
	public void deleteRoom(RoomInterface room) {
		
		try {
			roomDAO.deleteRoom(room);
	    } catch (Exception se) {
	      System.err.println("RoomManager: Threw a Exception retrieving room.");
	      System.err.println(se.getMessage());
	    }
	}
}