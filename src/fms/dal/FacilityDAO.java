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



public class FacilityDAO {
public FacilityDAO() {}
	
	public static Facility getFacilityID(int facilityID) {
		 	 
	    try { 		
	    	//Get Facility
	    	Statement st = DBHelper.getConnection().createStatement();
	    	String selectFacilityQuery = "SELECT facilityID FROM facility WHERE facilityID = '" + facilityID + "'";

	    	ResultSet facilityResults = st.executeQuery(selectFacilityQuery);      
	    	System.out.println("FacilityDAO: *************** Query " + selectFacilityQuery);
	    	
	      //Get Customer
    	  Facility facility = new Facility();
	      while ( facilityResults.next() ) {
	    	  facility.setFacilityID(facilityResults.getInt("facilityID"));
	    	//  facility.setFacilityInformation(facilityResults.getString("information"));
	      }
	      //close to manage resources
	      facilityResults.close();
	      	    		  
	      //Get Address
	      String selectRoomQuery = "SELECT roomID, capacity FROM room WHERE facilityID = '" + facilityID + "'";
	      ResultSet roomResults = st.executeQuery(selectRoomQuery);
    	  List<Room> rooms = new ArrayList<Room>();
    	  
    	  System.out.println("FacilityDAO: *************** Query " + selectRoomQuery);
    	  
	      while ( roomResults.next() ) {
	    	  Room newroom= new Room();
	    	  int id= roomResults.getInt("roomID");
	    	  int cap= roomResults.getInt("capacity");
	    	  newroom.setCapacity(cap);
	    	  newroom.setRoomID(id);
	    	  rooms.add(newroom);

	      }
	    //close to manage resources
	      roomResults.close();
	      
	      //String selectMaintQuery = "SELECT facilityID FROM facilityMaintenance WHERE facilityID = '" + facilityID + "'";
	      
	      
	      facility.setRooms(rooms);
	      //get details
	      String selectDetailsQuery = "SELECT address, information FROM details WHERE facilityID = '" + facilityID + "'";
	      ResultSet detailsResults= st.executeQuery(selectDetailsQuery);
	      System.out.println("FacilityDAO: ************** Query " + selectDetailsQuery);
	      while (detailsResults.next()){
	    	  
	    	  Details detail= new Details();
	    	  String add = detailsResults.getString("address");
	    	  String info = detailsResults.getString("information");
	    	  detail.setAddress(add);
	    	  detail.setInformation(info);
	    	  facility.setDetails(detail);
	      }
	      //close to manage resources
	      detailsResults.close();
	      
	      st.close();
	      
	      return facility;
	    }	    
	    catch (SQLException se) {
	      System.err.println("FacilityDAO: Threw a SQLException retrieving the facility object.");
	      System.err.println(se.getMessage());
	      se.printStackTrace();
	    }
	    
	    return null;
	  }
	
	public static void addFacility(Facility f) {
		
		Connection con = DBHelper.getConnection();
		PreparedStatement fPst = null;
        PreparedStatement roomPst = null;
        PreparedStatement detPst=null; 

        try {
        	//Insert the facility object
            String fStm = "INSERT INTO facility (facilityID) " + " VALUES (?)";
            fPst = con.prepareStatement(fStm);
            fPst.setInt(1, f.getFacilityID());
            fPst.executeUpdate();
            //Insert the detail object
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
            
            	
        }} catch (SQLException ex) {


        } finally {

            try {
                if (roomPst != null) {
                	roomPst.close();
                	fPst.close();
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

