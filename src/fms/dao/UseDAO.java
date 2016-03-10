package fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import fms.model.use.Customer;
import fms.model.use.FacilityUse;


public class UseDAO {

	public static FacilityUse getCustomerID(int customerID) {
	 	 
	    try { 		
	    	//Get FacilityUse
	    	Statement st = DBHelper.getConnection().createStatement();
	    	String selectUseQuery = "SELECT customerID, facilityID, startDate, endDate "+ " FROM facilityUse WHERE customerID = '" + customerID + "'";

	    	ResultSet useResults = st.executeQuery(selectUseQuery);      
	    	System.out.println("UseDAO: *************** Query " + selectUseQuery);
	    	
	    	//Get maintenanceRequest
	    	FacilityUse facilityUse = new FacilityUse();
	    	while ( useResults.next() ) {
	    		facilityUse.setCustomerID(useResults.getInt("customerID"));
	    		facilityUse.setFacilityID(useResults.getInt("facilityID"));
	    		facilityUse.setStartDate(useResults.getDate("startDate"));
	    		facilityUse.setEndDate(useResults.getDate("endDate"));
	      }
	      //close to manage resources
	      useResults.close();
	      //get customer
	      String selectCustomerQuery = "SELECT customerID, creditCard, userID FROM customer WHERE customerID = '" + facilityUse.getCustomerID() + "'";
	      ResultSet customerResults = st.executeQuery(selectCustomerQuery);
    		  
    	  System.out.println("UseDAO: *************** Query " + selectCustomerQuery);
    	  Customer c = new Customer();
	      while ( customerResults.next() ) {
	    	  
	    	  int cID= customerResults.getInt("customerID");
	    	  String cc = customerResults.getString("creditCard");
	    	  int uID = customerResults.getInt("userID");
	    	  
	    	  c.setCustomerID(cID);
	    	  c.setCreditCard(cc);
	    	  c.setUserID(uID);
	    	  facilityUse.setCustomer(c);
	      }
	      
	    //close to manage resources
	      customerResults.close();
	      	
	      String selectUserQuery = "SELECT firstName, lastName, userID, address, phoneNumber FROM user WHERE customerID = '" + customerID + "'";
	      ResultSet userResults = st.executeQuery(selectUserQuery);
    		  
    	  System.out.println("UseDAO: *************** Query " + selectUserQuery);
    	  
    	  
	      while ( userResults.next() ) {
	    	  
	    	  String fname= userResults.getString("firstName");
	    	  String lname = userResults.getString("lastName");
	    	  int userID = userResults.getInt("userID");
	    	  String address = userResults.getString("address");
	    	  String phoneNumber = userResults.getString("phoneNumber");
	    	  
	    	  c.setAddress(address);
	    	  c.setFirstName(fname);
	    	  c.setLastName(lname);
	    	  c.setUserID(userID);
	    	  c.setPhoneNumber(phoneNumber);
	      }
	      
	      
	    //close to manage resources
	      customerResults.close();
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
        PreparedStatement custPst = null;
        PreparedStatement userPst=null; 
        PreparedStatement useSchedPst=null;

        try {
        	//Insert the FacilityUse object
            String useStm = "INSERT INTO facilityUse (facilityID, customerID, startDate, endDate) " + " VALUES (?, ?, ?, ?)";
            usePst = con.prepareStatement(useStm);
            usePst.setInt(1, use.getFacility().getFacilityID());
            usePst.setInt(2, use.getCustomer().getCustomerID());
            usePst.setDate(3, new java.sql.Date(use.getStartDate().getTime()));
            usePst.setDate(4, new java.sql.Date(use.getEndDate().getTime()));
            usePst.executeUpdate();
            //Insert the customer object
            String custStm = "INSERT INTO customer (creditCard, customerID, userID) " + " VALUES (?, ?, ?)";
            custPst = con.prepareStatement(custStm);
            custPst.setString(1, use.getCustomer().getCreditCard());
            custPst.setInt(2, use.getCustomer().getCustomerID());
            custPst.setInt(3, use.getCustomer().getUserID());
            custPst.executeUpdate();
            //Insert user object
           
            String userStm = "INSERT INTO user (customerID, userID, firstName, lastName, address, phoneNumber) " + " VALUES (?, ?, ?, ?, ?, ?)";
            userPst = con.prepareStatement(userStm);
            userPst.setInt(1, use.getCustomer().getCustomerID());
            userPst.setInt(2, use.getCustomer().getUserID());
            userPst.setString(3, use.getCustomer().getFirstName());
            userPst.setString(4, use.getCustomer().getLastName());
            userPst.setString(5,  use.getCustomer().getAddress());
            userPst.setString(6,  use.getCustomer().getPhoneNumber());
            
            userPst.executeUpdate();
            
            int days= (int)(TimeUnit.DAYS.convert(use.getEndDate().getTime()- use.getStartDate().getTime(), TimeUnit.MILLISECONDS));
            long milliInADay = 1000 * 60 * 60 * 24;
            for (int i=0; i<=days; i++){
            	String useSchedStm = "INSERT INTO useSchedule (facilityID, isInUse, useDate) " + " VALUES(?, ?, ?)";
            	useSchedPst = con.prepareStatement(useSchedStm);
            	useSchedPst.setInt(1, use.getFacility().getFacilityID());
            	useSchedPst.setBoolean(2, use.getUseSchedule().isInUse());
            	useSchedPst.setDate(3, new java.sql.Date (use.getStartDate().getTime() + i*milliInADay));
            	useSchedPst.executeUpdate();
            }
            
        
        } catch (SQLException ex) {


        } finally {

            try {
                if (custPst != null) {
                	custPst.close();
                	//fPst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
      	      System.err.println("UseDAO: Threw a SQLException saving the facility use object.");
    	      System.err.println(ex.getMessage());
            }
        }
    }
}


