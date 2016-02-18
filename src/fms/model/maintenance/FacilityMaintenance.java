package fms.model.maintenance;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fms.model.facility.Facility;

public class FacilityMaintenance implements IFacilityMaintenance {
	private int requestID;
	private Request request;
	private List<Request> listRequests = new ArrayList<Request>();
	private int facilityID;
	private Facility facility;
	private Cost cost;

	
	
	public FacilityMaintenance(){
		
	}
	
	@Override
	public Request makeFacilityMaintRequest(Request request) {
		this.request=request;
		listRequests.add(request);
		return request;

	}

	@Override
	public String scheduleMaintenance(String date) {
		request.setRequestDate(date);
		return date;

	}

	@Override
	public int calcMaintenanceCostForFacility(Request request) {
		int days = request.getCompleteDate().compareTo(request.getRequestDate()) +1;
		int amount = getCost().getCost();
		return days*amount;
		
	}

	@Override
	public int calcProblemRateForFacility() {
		//TODO 
		return 0;
	}

	@Override
	public int calcDownTimeForFacility(Request request) {
		int days = request.getCompleteDate().compareTo(request.getRequestDate()) +1;
		return days;
	}

	@Override
	public List<Request> listMaintRequests() {
		return listRequests;
		
	}

	@Override
	public String listMaintenance() {
		String maint="";
		for (Request r : listRequests) {
			maint += r.getRequestID()+"\n";
			}
		return maint;
	}

	@Override
	public String listFacilityProblems() {
		String prob="";
		for (Request r : listRequests) {
			prob+= r.getProblem() +"\n";
		}
		return prob;
	}

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	public int getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(int facilityID) {
		this.facilityID = facilityID;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}
	public Request getRequest(){
		return request;
	}
	public void setRequest(Request request) {
		this.request=request;
	}



}
