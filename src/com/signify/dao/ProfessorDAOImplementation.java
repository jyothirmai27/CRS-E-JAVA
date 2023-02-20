/**
 * 
 */
package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.signify.bean.Professor;

/**
 * @author BHAVISH
 *
 */
public class ProfessorDAOImplementation implements ProfessorDAOInterface{
	
	  // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/crs_e";

	  //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "Password@1";
	@Override
	
	public void update(String query) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Professor professor) {
		// TODO Auto-generated method stub
		 
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   try{
			   			   
			   //Class.forName("com.mysql.jdbc.Driver");
			   
			    //  System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			      //System.out.println("Creating statement...");
			      String sql="insert into professor values(?,?,?)";
			      stmt = conn.prepareStatement(sql);
			   
			      int userid=Integer.parseInt(professor.getUserId());
			      String name=professor.getProfessorName();
			      String password=professor.getPassword();
			      
			      stmt.setInt(1, userid); 
			      stmt.setString(2,name);
			      stmt.setString(3, password);
			      
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
			  // System.out.println("Goodbye!");
	}

	@Override
	public void delete(String professorId) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		   PreparedStatement stmt = null;	
		   try{
			   
			   //Class.forName("com.mysql.jdbc.Driver");
			   
		      //System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      String sql="delete from professor where userid=?";
		      stmt = conn.prepareStatement(sql);
		      stmt.setInt(1, Integer.parseInt(professorId));
	            // execute the delete statement
	           stmt.executeUpdate();
		     
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
		   //System.out.println("Goodbye!");
		
	}

	@Override
	public void view(String query) {
		// TODO Auto-generated method stub
		
	}
	
	

}
