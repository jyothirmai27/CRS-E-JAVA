/**
 * 
 */
package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.signify.bean.Admin;
import com.signify.constants.SQLConstants;
import com.signify.exception.AdminDoesntExistException;
import com.signify.utils.DBUtils;

/**
 * @author BHAVISH
 *
 */

public class AdminDAOImplementation implements AdminDAOInterface{


	Connection conn = null;
    PreparedStatement stmt = null;
	
	@Override
	public void update(String query) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(int id, Admin admin) {
		// TODO Auto-generated method stub
		   try{
			   conn = DBUtils.getConnection();
			   
			      stmt = conn.prepareStatement(SQLConstants.ADD_ADMIN);
			      String name=admin.getAdminName();
			      
			      stmt.setInt(1, id); 
			      stmt.setString(2,name);
			      
			      stmt.executeUpdate();
			      stmt.close();
			      conn.close();
			      
			   }catch(SQLException se){		//Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{  			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
			   System.out.println("Admin Added!");
	}

	@Override
	public void remove(String adminId) throws AdminDoesntExistException {
		// TODO Auto-generated method stub
		 try{
			 conn = DBUtils.getConnection();
		      stmt = conn.prepareStatement(SQLConstants.DELETE_ADMIN + Integer.parseInt(adminId));
		     
		      if(stmt.execute())
		    	  throw new AdminDoesntExistException();
		     
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Admin Removed!");
	}

	@Override
	public void view(String query) {
		// TODO Auto-generated method stub
		
	}

}
