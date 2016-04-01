package fms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fms.model.facility.RoomInterface;

public class RoomHibernateDAO {

	public void addRoom(RoomInterface room) {
		System.out.println("*************** Adding room information in DB with ID ...  " + room.getRoomID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(room);
		session.getTransaction().commit();
	}
	
	public void deleteRoom(RoomInterface room) {
		System.out.println("*************** Deleteing customer information in DB with ID ...  " + room.getRoomID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(room);
		session.getTransaction().commit();
	}
	
	public RoomInterface retrieveRoom(int roomId) {
		try {
		System.out.println("*************** Searching for room information with ID ...  " + roomId);
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	
		Query getRoomQuery = session.createQuery("From Room where roomId=:roomId");		
		getRoomQuery.setInteger("roomId", roomId);
		
		System.out.println("*************** Retrieve Query is ....>>\n" + getRoomQuery.toString()); 
		
		List roomList = getRoomQuery.list();
		System.out.println("Getting Room Room using HQL. \n" + roomList);

		session.getTransaction().commit();
		return (RoomInterface)roomList.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}