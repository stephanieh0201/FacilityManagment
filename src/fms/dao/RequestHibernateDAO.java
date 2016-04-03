package fms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fms.model.maintenance.RequestInterface;

public class RequestHibernateDAO {

	public void addRequest(RequestInterface request) {
		System.out.println("*************** Adding request information in DB with ID ...  " + request.getRequestID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(request);
		session.getTransaction().commit();
	}
	
	public void deleteRequest(RequestInterface request) {
		System.out.println("*************** Deleteing request information in DB with ID ...  " + request.getRequestID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(request);
		session.getTransaction().commit();
	}
	
	public RequestInterface retrieveRequest(int requestId) {
		try {
		System.out.println("*************** Searching for request information with ID ...  " + requestId);
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	
		Query getRequestQuery = session.createQuery("From Request where requestId=:requestId");		
		getRequestQuery.setInteger("requestId", requestId);
		
		System.out.println("*************** Retrieve Query is ....>>\n" + getRequestQuery.toString()); 
		
		List requestList = getRequestQuery.list();
		System.out.println("Getting Request Request using HQL. \n" + requestList);

		session.getTransaction().commit();
		return (RequestInterface)requestList.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}