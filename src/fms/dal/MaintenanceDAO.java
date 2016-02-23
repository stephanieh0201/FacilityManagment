package fms.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import fms.model.maintenance.Cost;
import fms.model.maintenance.FacilityMaintenance;
import fms.model.maintenance.Problem;
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
	      String selectRequestQuery = "SELECT problemID, requestDate, completeDate, days FROM request WHERE requestID = '" + requestID + "'";
	      ResultSet requestResults= st.executeQuery(selectRequestQuery);
	      System.out.println("MaintenanceDAO: ************** Query " + selectRequestQuery);
	      Request request = new Request();
	      while (requestResults.next()){
	    	  
	    	  int prob = requestResults.getInt("problemID");
	    	  Date requestDate = requestResults.getDate("requestDate");
	    	  Date completeDate = requestResults.getDate("completeDate");
	    	  int days = requestResults.getInt("days");
	    	  
	    	  request.setRequestDate(requestDate);
	    	  request.setCompleteDate(completeDate);
	    	  request.setDays(days);
	    	  facilityMaint.setRequest(request);
	    	 
		      
	      }
	      //close to manage resources
	      requestResults.close();
	     
	      String selectProblemQuery = "SELECT problemID, problem FROM problem WHERE problemID = '" + request + "'";
    	  ResultSet problemResults= st.executeQuery(selectProblemQuery);
	      System.out.println("MaintenanceDAO: ************** Query " + selectProblemQuery);
	      
	      while (problemResults.next()){
	    	  Problem problem = new Problem();
	    	  int probID = problemResults.getInt("problemID"); 
	    	  String problemText = problemResults.getString("problem");
	    	  problem.setProblemID(probID);
	    	  problem.setProblem(problemText);
	    	  
	    	  request.setProblem(problem);
	    	  
	      }
	      
	      problemResults.close();
	      st.close();
	      
	      return facilityMaint;
	    }	    
	    catch (SQLException se) {
	      System.err.println("MaintenanceDAO: Threw a SQLException retrieving the facility object.");
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
        PreparedStatement schedulePst=null;

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
            String requestStm = "INSERT INTO request (completeDate, days, requestDate, problemID, requestID) " + " VALUES(?, ?, ?, ?, ?)";
            requestPst = con.prepareStatement(requestStm);
            requestPst.setDate(1, new java.sql.Date (req.getRequest().getCompleteDate().getTime()));
            requestPst.setInt(2, req.getRequest().getDays());
            requestPst.setDate(3, new java.sql.Date(req.getRequest().getRequestDate().getTime()));
            requestPst.setInt(4, req.getRequest().getProblem().getProblemID());
            
            requestPst.setInt(5, req.getRequestID());
            requestPst.executeUpdate();
            //insert schedule object
            
            int days= req.getRequest().getCompleteDate().compareTo(req.getRequest().getRequestDate());
            long milliInADay = 1000 * 60 * 60 * 24;
            for (int i=0; i<=days; i++){
            	String scheduleStm = "INSERT INTO maintenanceSchedule (facilityID, reserveDate, status) " + " VALUES(?, ?, ?)";
            	schedulePst = con.prepareStatement(scheduleStm);
            	schedulePst.setInt(1, req.getFacility().getFacilityID());
            	schedulePst.setDate(2, new java.sql.Date (req.getRequest().getRequestDate().getTime() + i*milliInADay));
            	schedulePst.setBoolean(3, req.getRequest().getMaintenanceSchedule().getStatus());

            	schedulePst.executeUpdate();
            }
        
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
      	      System.err.println("MaintenanceDAO: Threw a SQLException saving the facility object.");
    	      System.err.println(ex.getMessage());
            }
        }
    }
}


