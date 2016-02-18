package fms.model.maintenance;

import java.util.Date;

import fms.model.facility.Facility;

public class Request {
	private int requestID;
	private String problem;
	private Facility facility;
	private String requestDate;
	private String completeDate;
	private int days;

	
	public Request(
			//int requestID, String problem, Facility facility, Date requestDate, Date completeDate
			) {
//		this.requestID=requestID;
//		this.problem=problem;
//		this.facility=facility;
//		this.requestDate=requestDate;
//		this.completeDate=completeDate;
//		cost=new Cost(problem);
		
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

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
	
}
