package fms.model.maintenance;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FacilityMaintenance implements IFacilityMaintenance {
	private int ID;
	private Request request;
	//private int cost=100;
	private List<Request> listRequests = new ArrayList<Request>();
	
	
	public FacilityMaintenance(){
		
	}
	
	@Override
	public void makeFacilityMaintRequest(Request request) {
		this.request=request;
		listRequests.add(request);

	}

	@Override
	public void scheduleMaintenance(Date date) {
		request.setRequestDate(date);
		

	}

	@Override
	public int calcMaintenanceCostForFacility(Request request) {
		int days = request.getCompleteDate().compareTo(request.getRequestDate()) +1;
		int amount = request.getCost()
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
	public void listMaintRequests() {
		for (Request r : listRequests) {
			System.out.println(r.getRequestID());
		}

	}

	@Override
	public void listMaintenance() {
		for (Request r : listRequests) {
			System.out.println(r.getRequestDate());
			}

	}

	@Override
	public void listFacilityProblems() {
		for (Request r : listRequests) {
			System.out.println(r.getProblem());
		}

	}



}
