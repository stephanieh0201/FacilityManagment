package fms.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fms.model.facility.Details;
import fms.model.facility.Facility;
import fms.model.facility.Room;
import fms.model.maintenance.Cost;
import fms.model.maintenance.FacilityMaintenance;
import fms.model.maintenance.Request;

public class MaintenanceDAO {

	public static FacilityMaintenance getRequestID(int requestID) {
	 	 
	    try { 		
	    	//Get FacilityMaintenance
	    	Statement st = DBHelper.getConnection().createStatement();
	    	String selectMaintQuery = "SELECT requestID, facilityID FROM facilityMaintenance WHERE requestID = '" + requestID + "'";

	    	ResultSet maintResults = st.executeQuery(selectMaintQuery);      
	    	System.out.println("MaintenanceDAO: *************** Query " + selectMaintQuery);
	    	
	    	//Get maintenanceRequest
	    	FacilityMaintenance facilityMaint = new FacilityMaintenance();
	    	while ( maintResults.next() ) {
	    		facilityMaint.setRequestID(maintResults.getInt("requestID"));
	    		facilityMaint.setFacilityID(maintResults.getInt("facilityID"));
	    
	      }
	      //close to manage resources
	      maintResults.close();
	      	 		  
	      //Get Cost
	      String selectCostQuery = "SELECT maintenanceCost FROM cost WHERE requestID = '" + requestID + "'";
	      ResultSet costResults = st.executeQuery(selectCostQuery);
    		  
    	  System.out.println("MaintenanceDAO: *************** Query " + selectCostQuery);
    	  
	      while ( costResults.next() ) {
	    	  Cost newcost= new Cost();
	    	  int cost= costResults.getInt("maintenanceCost");
	    	  newcost.setCost(cost);
	    	  newcost.setRequestID(requestID);
	    	  facilityMaint.setCost(newcost);
	      }
	      
	    //close to manage resources
	      costResults.close();
	      
	      //get request
	      String selectRequestQuery = "SELECT problem, requestDate, completeDate, days FROM request WHERE requestID = '" + requestID + "'";
	      ResultSet requestResults= st.executeQuery(selectRequestQuery);
	      System.out.println("MaintenanceDAO: ************** Query " + selectRequestQuery);
	      while (requestResults.next()){
	    	  
	    	  Request request = new Request();
	    	  String prob = requestResults.getString("problem");
	    	  String requestDate = requestResults.getString("requestDate");
	    	  String completeDate = requestResults.getString("completeDate");
	    	  int days = requestResults.getInt("days");
	    	  request.setProblem(prob);
	    	  request.setRequestDate(requestDate);
	    	  request.setCompleteDate(completeDate);
	    	  request.setDays(days);
	    	  facilityMaint.setRequest(request);
	      }
	      //close to manage resources
	      requestResults.close();
	      
	      st.close();
	      
	      return facilityMaint;
	    }	    
	    catch (SQLException se) {
	      System.err.println("FacilityDAO: Threw a SQLException retrieving the facility object.");
	      System.err.println(se.getMessage());
	      se.printStackTrace();
	    }
	    
	    return null;
	  }
	
	public static void addMaintRequest(FacilityMaintenance req) {
		
		Connection con = DBHelper.getConnection();
		PreparedStatement maintPst = null;
        PreparedStatement costPst = null;
        PreparedStatement requestPst=null; 

        try {
        	//Insert the FacilityMaintenance object
            String maintStm = "INSERT INTO facilityMaintenance (facilityID, requestID) " + " VALUES (?, ?)";
            maintPst = con.prepareStatement(maintStm);
            maintPst.setInt(1, req.getFacilityID());
            maintPst.setInt(2, req.getRequestID());
            maintPst.executeUpdate();
            
            //Insert the cost object
            String costStm = "INSERT INTO cost (maintenanceCost, requestID) " + " VALUES (?, ?)";
            costPst = con.prepareStatement(costStm);
            costPst.setInt(1, req.getCost().getCost());
            costPst.setInt(2, req.getRequest().getRequestID());
            costPst.executeUpdate();
            
            //Insert the request object
            String requestStm = "INSERT INTO request (completeDate, days, requestDate, problem, requestID) " + " VALUES(?, ?, ?, ?, ?)";
            requestPst = con.prepareStatement(requestStm);
            requestPst.setString(1, req.getRequest().getCompleteDate());
            requestPst.setInt(2, req.getRequest().getDays());
            requestPst.setString(3, req.getRequest().getRequestDate());
            requestPst.setString(4, req.getRequest().getProblem());
            requestPst.setInt(5, req.getRequestID());
            requestPst.executeUpdate();
         	
        
        } catch (SQLException ex) {


        } finally {

            try {
                if (costPst != null) {
                	costPst.close();
                	//fPst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
      	      System.err.println("FacilityDAO: Threw a SQLException saving the facility object.");
    	      System.err.println(ex.getMessage());
            }
        }
    }
}


