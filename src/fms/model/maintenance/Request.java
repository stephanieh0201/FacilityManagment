package fms.model.maintenance;

import java.util.ArrayList;
import java.util.Date;

import fms.model.facility.Facility;
import fms.model.facility.FacilityInterface;

public class Request implements RequestInterface{
	private int requestID;
	private FacilityInterface facility;
	private Date requestDate;
	private Date completeDate;
	private ProblemInterface problem;
	private int problemID;
	private MaintenanceScheduleInterface maintenanceSchedule;
	
	public Request() {
	}
	public String toString(){
		return "Request " + getRequestID() + " on " + getRequestDate() + " for " + getProblem();
	}

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}


	public FacilityInterface getFacility() {
		return facility;
	}

	public void setFacility(FacilityInterface facility) {
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


	public ProblemInterface getProblem() {
		return problem;
	}

	public void setProblem(ProblemInterface problem) {
		this.problem = problem;
	}

	
	public MaintenanceScheduleInterface getMaintenanceSchedule() {
		return maintenanceSchedule;
	}

	public void setMaintenanceSchedule(MaintenanceScheduleInterface maintenanceSchedule) {
		this.maintenanceSchedule = maintenanceSchedule;
	}

	public int getProblemID() {
		return problemID;
	}

	public void setProblemID(int problemID) {
		this.problemID = problemID;
	}

}
