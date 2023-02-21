/**
 * 
 */
package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.signify.bean.Professor;
import com.signify.helper.IDs;
import com.signify.service.UserLoginServices;

/**
 * @author BHAVISH
 *
 */
public class ProfessorDAOImplementation implements ProfessorDAOInterface{
	

	   Connection conn = null;
	   PreparedStatement stmt = null;
	
	@Override
	public void insert(int id, Professor professor) {
		// TODO Auto-generated method stub
		 
		   try{
			      conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			   
			      //System.out.println("Creating statement...");
			      String sql="insert into professor values(?,?,?,?,?)";
			      stmt = conn.prepareStatement(sql);
			   
			      stmt.setInt(1, id); 
			      stmt.setString(2,professor.getDesignation());
			      stmt.setString(3, professor.getProfessorName());
			      stmt.setString(4, professor.getDepartmentName());
			      stmt.setString(5, professor.getPhoneNumber());
			      
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
			   conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
		      String sql="delete from professor where profId = "+professorId;
		      stmt = conn.prepareStatement(sql);
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

	@Override
	public void update(String update, String id, String field) {
		// TODO Auto-generated method stub
		try{
			   
			   //Class.forName("com.mysql.jdbc.Driver");
			   
			    //  System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			      String sql="update professor set ";
			      switch(field) {
					case "1": sql+="professorName = "+update;
					break;
					case "2":sql+="designation = "+update;
					break;
					case "3": sql+="departmentName = "+update;
					break;
					case "5":sql+="phoneNumber = "+update;
					break;
					default : System.out.println("Enter valid numeric input.");
					}
			      sql+="where profId = "+id;
			      stmt = conn.prepareStatement(sql);
			      if(stmt.execute())
			    	  System.out.println("There was some error.");
			      else
			    	  System.out.println("Updated!");
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
			   }
	}

	
	

}
