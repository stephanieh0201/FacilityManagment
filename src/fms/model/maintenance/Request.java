package fms.model.maintenance;

import java.util.Date;

import fms.model.facility.Facility;

public class Request {
	private int requestID;
	private String problem;
	private Facility facility;
	private Date requestDate;
	private Date completeDate;
	
	public Request(int requestID, String problem, Facility facility, Date requestDate, Date completeDate) {
		this.requestID=requestID;
		this.problem=problem;
		this.facility=facility;
		this.requestDate=requestDate;
		this.completeDate=completeDate;
		
	}

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Date getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}
	
	
}
