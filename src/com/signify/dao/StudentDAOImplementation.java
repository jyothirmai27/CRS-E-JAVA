/**
 * 
 */
package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.signify.bean.Student;
import com.signify.helper.*;

/**
 * @author BHAVISH
 *
 */
public class StudentDAOImplementation implements StudentDAOInterface{

	
	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub
		Connection conn = null;
		   PreparedStatement stmt = null;
		   try{
			   			   
			  // Class.forName("com.mysql.jdbc.Driver");
			   
			      //System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			   
			      //System.out.println("Creating statement...");
			      String sql="insert into student values(?,?,?,?,?,?,?,?,?)";
			      stmt = conn.prepareStatement(sql);
			   
			      int userid=Integer.parseInt(student.getUserId());
			      String name=student.getStudentName();
			      String password=student.getPassword();
			      
			      stmt.setInt(1, userid); 
			      stmt.setString(2,name);
			      stmt.setString(5, password);
			      stmt.setString(3, student.getAddress());
			      stmt.setString(4, student.getBranchName());
			      stmt.setString(6, student.getScholarshipId());
			      stmt.setString(7, student.getBatch());
			      stmt.setString(8, student.getPhoneNumber());
			      stmt.setInt(9, 0);
			      
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
	public void delete(String studentId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		   PreparedStatement stmt = null;	
		   try{
			   
			   //Class.forName("com.mysql.jdbc.Driver");
			   
		      //System.out.println("Connecting to database...");
			   conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
		      String sql="delete from student where userid=?";
		      stmt = conn.prepareStatement(sql);
		      stmt.setInt(1, Integer.parseInt(studentId));
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
		   //System.out.println("Student Removed!");
	}

	@Override
	public void update(String query) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void view(String query) {
		// TODO Auto-generated method stub
		
	}

}
