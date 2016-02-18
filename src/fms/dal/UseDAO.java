package fms.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fms.model.maintenance.FacilityMaintenance;
import fms.model.use.FacilityUse;

public class UseDAO {

	public static FacilityUse getCustomerID(int customerID) {
	 	 
	    try { 		
	    	//Get FacilityUse
	    	Statement st = DBHelper.getConnection().createStatement();
	    	String selectUseQuery = "SELECT customerID, facilityID, startDate, endDate, days FROM facilityUse WHERE customerID = '" + customerID + "'";

	    	ResultSet useResults = st.executeQuery(selectUseQuery);      
	    	System.out.println("UseDAO: *************** Query " + selectUseQuery);
	    	
	    	//Get maintenanceRequest
	    	FacilityUse facilityUse = new FacilityUse();
	    	while ( useResults.next() ) {
	    		facilityUse.setCustomerID(useResults.getInt("customerID"));
	    		facilityUse.setFacilityID(useResults.getInt("facilityID"));
	    		facilityUse.setStartDate(useResults.getString("startDate"));
	    		facilityUse.setEndDate(useResults.getString("endDate"));
	    		facilityUse.setDays(useResults.getInt("days"));
	      }
	      //close to manage resources
	      useResults.close();
	      	
	      st.close();
	      
	      return facilityUse;
	    }	    
	    catch (SQLException se) {
	      System.err.println("UseDAO: Threw a SQLException retrieving the facilityUse object.");
	      System.err.println(se.getMessage());
	      se.printStackTrace();
	    }
	    
	    return null;
	  }
	
	public static void addUseRequest(FacilityUse use) {
		
		Connection con = DBHelper.getConnection();
		PreparedStatement usePst = null;
        PreparedStatement roomPst = null;
        //PreparedStatement detPst=null; 

        try {
        	//Insert the FacilityUse object
            String useStm = "INSERT INTO facilityUse (facilityID, customerID, startDate, endDate, days) " + " VALUES (?, ?, ?, ?, ?)";
            usePst = con.prepareStatement(useStm);
            usePst.setInt(1, use.getFacilityID());
            usePst.setInt(2, use.getCustomerID());
            usePst.setString(3, use.getStartDate());
            usePst.setString(4, use.getEndDate());
            usePst.setInt(5, use.getDays());
            usePst.executeUpdate();
         /*   //Insert the detail object
            String detStm = "INSERT INTO details (address, facilityID, information) " + " VALUES (?, ?, ?)";
            detPst = con.prepareStatement(detStm);
            detPst.setString(1, f.getDetails().getAddress());
            detPst.setInt(2, f.getFacilityID());
            detPst.setString(3, f.getDetails().getInformation());
            detPst.executeUpdate();
            
            for (Room r : f.getRooms()){
    	//Insert the room object
            	String roomStm = "INSERT INTO room (capacity, facilityID, roomId) " + " VALUES(?, ?, ?)";
            	roomPst = con.prepareStatement(roomStm);
            	roomPst.setInt(1, r.getCapacity());
            	roomPst.setInt(2, r.getFacility().getFacilityID());
            	roomPst.setInt(3, r.getRoomID());
            	roomPst.executeUpdate();
            
         }*/   	
        
        } catch (SQLException ex) {


        } finally {

            try {
                if (roomPst != null) {
                	roomPst.close();
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


