package fms.model.manager;

import fms.dao.RequestHibernateDAO;
import fms.model.maintenance.RequestInterface;

public class RequestManager {

	private RequestHibernateDAO requestDAO = new RequestHibernateDAO();
	
	public void addRequest(RequestInterface request) {
		try {
			requestDAO.addRequest(request);
	    } catch (Exception se) {
	      System.err.println("RequestManager: Threw a Exception adding request.");
	      System.err.println(se.getMessage());
	    }
	}
	
	public RequestInterface findRequestById(int requestId) {
		try {
			RequestInterface request = requestDAO.retrieveRequest(requestId);
	    	return request;
	    } catch (Exception se) {
	      System.err.println("RequestManager: Threw a Exception retrieving request.");
	      System.err.println(se.getMessage());
	    }
		return null;
	}
	
	public void deleteRequest(RequestInterface request) {
		
		try {
			requestDAO.deleteRequest(request);
	    } catch (Exception se) {
	      System.err.println("RequestManager: Threw a Exception retrieving request.");
	      System.err.println(se.getMessage());
	    }
	}
}