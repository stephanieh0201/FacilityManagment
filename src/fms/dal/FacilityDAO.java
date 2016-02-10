package fms.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fms.model.facility.Facility;
import fms.model.facility.Room;



public class FacilityDAO {
public FacilityDAO() {}
	
	public static Facility getFacilityID(int facilityID) {
		 	 
	    try { 		
	    	//Get Facility
	    	Statement st = DBHelper.getConnection().createStatement();
	    	String selectFacilityQuery = "SELECT facilityID, information FROM facility WHERE facilityID = '" + facilityID + "'";

	    	ResultSet facilityResults = st.executeQuery(selectFacilityQuery);      
	    	System.out.println("FacilityDAO: *************** Query " + selectFacilityQuery);
	    	
	      //Get Customer
    	  Facility facility = new Facility();
	      while ( facilityResults.next() ) {
	    	  facility.setFacilityID(facilityResults.getInt("facilityID"));
	    	  facility.setFacilityInformation(facilityResults.getString("information"));
	      }
	      //close to manage resources
	      facilityResults.close();
	      	    		  
	      //Get Address
	      String selectRoomQuery = "SELECT roomID, capacity FROM room WHERE facilityID = '" + facilityID + "'";
	      ResultSet roomResults = st.executeQuery(selectRoomQuery);
    	  List<Room> rooms = new ArrayList<Room>();
    	  
    	  System.out.println("FacilityDAO: *************** Query " + selectRoomQuery);
    	  
	      while ( roomResults.next() ) {
	    	  rooms.add(new Room (roomResults.getInt("roomID"), roomResults.getInt("capacity")));

	      }
	      
	      facility.setRooms(rooms);
	      //close to manage resources
	      roomResults.close();
	      st.close();
	      
	      return facility;
	    }	    
	    catch (SQLException se) {
	      System.err.println("CustomerDAO: Threw a SQLException retrieving the customer object.");
	      System.err.println(se.getMessage());
	      se.printStackTrace();
	    }
	    
	    return null;
	  }
	
//	public void addCustomer(Customer cust) {
//		Connection con = DBHelper.getConnection();
//        PreparedStatement custPst = null;
//        PreparedStatement addPst = null;
//
//        try {
//        	//Insert the customer object
//            String custStm = "INSERT INTO Customer(customerID, lname, fname) VALUES(?, ?, ?)";
//            custPst = con.prepareStatement(custStm);
//            custPst.setString(1, cust.getCustomerId());
//            custPst.setString(2, cust.getLastName());       
//            custPst.setString(3, cust.getFirstName()); 
//            custPst.executeUpdate();
//
//        	//Insert the customer address object
//            String addStm = "INSERT INTO Address(customerID, addressID, street, unit, city, state, zip) VALUES(?, ?, ?, ?, ?, ?, ?)";
//            addPst = con.prepareStatement(addStm);
//            addPst.setString(1, cust.getCustomerId());
//            addPst.setString(2, cust.getBillingAddress().getAddressId());  
//            addPst.setString(3, cust.getBillingAddress().getStreet());       
//            addPst.setString(4, cust.getBillingAddress().getUnit());  
//            addPst.setString(5, cust.getBillingAddress().getCity());  
//            addPst.setString(6, cust.getBillingAddress().getState());      
//            addPst.setString(7, cust.getBillingAddress().getZip());  
//            addPst.executeUpdate();
//        } catch (SQLException ex) {
//
//        } finally {
//
//            try {
//                if (addPst != null) {
//                	addPst.close();
//                	custPst.close();
//                }
//                if (con != null) {
//                    con.close();
//                }
//
//            } catch (SQLException ex) {
//      	      System.err.println("CustomerDAO: Threw a SQLException saving the customer object.");
//    	      System.err.println(ex.getMessage());
//            }
//        }
//    }
}

