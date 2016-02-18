package fms.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fms.model.maintenance.Cost;
import fms.model.maintenance.FacilityMaintenance;
import fms.model.use.Customer;
import fms.model.use.FacilityUse;
import fms.model.use.User;

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
	      //get customer
	      String selectCustomerQuery = "SELECT customerID, creditCard, salary, userID FROM customer WHERE customerID = '" + facilityUse.getCustomerID() + "'";
	      ResultSet customerResults = st.executeQuery(selectCustomerQuery);
    		  
    	  System.out.println("UseDAO: *************** Query " + selectCustomerQuery);
    	  Customer c = new Customer();
	      while ( customerResults.next() ) {
	    	  
	    	  int cID= customerResults.getInt("customerID");
	    	  String cc = customerResults.getString("creditCard");
	    	  double salary = customerResults.getDouble("salary");
	    	  int uID = customerResults.getInt("userID");
	    	  
	    	  c.setCustomerID(cID);
	    	  c.setCreditCard(cc);
	    	  c.setSalary(salary);
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
            //Insert the customer object
            String custStm = "INSERT INTO customer (creditCard, customerID, salary, userID) " + " VALUES (?, ?, ?, ?)";
            custPst = con.prepareStatement(custStm);
            custPst.setString(1, use.getCustomer().getCreditCard());
            custPst.setInt(2, use.getCustomerID());
            custPst.setDouble(3, use.getCustomer().getSalary());
            custPst.setInt(4, use.getCustomer().getCUserID());
            custPst.executeUpdate();
            //Insert user object
            
            String userStm = "INSERT INTO user (customerID, userID, firstName, lastName, address, phoneNumber) " + " VALUES (?, ?, ?, ?, ?, ?)";
            userPst = con.prepareStatement(userStm);
            userPst.setInt(1, use.getCustomerID());
            userPst.setInt(2, use.getCustomer().getCUserID());
            userPst.setString(3, use.getCustomer().getFirstName());
            userPst.setString(4, use.getCustomer().getLastName());
            userPst.setString(5,  use.getCustomer().getAddress());
            userPst.setString(6,  use.getCustomer().getPhoneNumber());
            
            userPst.executeUpdate();
            
           	
        
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


