/**
 * 
 */
package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.signify.bean.Student;
import com.signify.helper.*;

/**
 * @author BHAVISH
 *
 */
public class StudentDAOImplementation implements StudentDAOInterface{

	Connection conn = null;
	PreparedStatement stmt = null;
	@Override
	public void add(int id, Student student) {
		// TODO Auto-generated method stub
	
		   try{
			   			   
			  // Class.forName("com.mysql.jdbc.Driver");
			   
			      //System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			   
			      //System.out.println("Creating statement...");
			      String sql="insert into student values(?,?,?,?,?,?,?,?)";
			      stmt = conn.prepareStatement(sql);
			      String name=student.getStudentName();
			      stmt.setInt(1, id); 
			      stmt.setString(2,name);
			      stmt.setString(3, student.getAddress());
			      stmt.setString(4, student.getBranchName());
			      stmt.setString(5, student.getScholarshipId());
			      stmt.setString(6, student.getBatch());
			      stmt.setString(7, student.getPhoneNumber());
			      stmt.setInt(8, 0);
			      
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
			
		   try{
			   
			   //Class.forName("com.mysql.jdbc.Driver");
			   
		      //System.out.println("Connecting to database...");
			   conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
		      String sql="delete from student where userId = "+studentId;
		      stmt = conn.prepareStatement(sql);
		      //stmt.setInt(1, Integer.parseInt(studentId));
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
		try{
			   
			   //Class.forName("com.mysql.jdbc.Driver");
			   
			    //  System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			      String sql="update student set "+query;
			      stmt = conn.prepareStatement(sql);
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
			   }
		
	}

	@Override
	public void view() {
		// TODO Auto-generated method stub
		 try{
			 conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			   
			      //System.out.println("Creating statement...");
			      String sql = "SELECT studentId, studentName, branchName FROM student WHERE approved = 1";

			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);
			      System.out.println("Id \t\t Name \t\t Branch ");
			      while(rs.next()){
				         //Retrieve by column name
				       	int studentId = rs.getInt("studentId");
				         String name1 = rs.getString("studentName");
				         String branch = rs.getString("branchName");
				         //Display values
				         System.out.println( Integer.toString(studentId)+"\t\t" + name1+"\t\t" + branch);
				      }
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
	}
	
	

	@Override
	public void approveAll() {
		// TODO Auto-generated method stub
		try{
			   
			   //Class.forName("com.mysql.jdbc.Driver");
			   
			    //  System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			   
			      //System.out.println("Creating statement...");
			      String sql = "UPDATE student SET approved = 1";

			      stmt = conn.prepareStatement(sql);
			      if(stmt.execute())
			    	  System.out.println("approved");
			      else
			    	  System.out.println("There was some error.");
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
	}

	@Override
	public void approve(String id) {
		// TODO Auto-generated method stub
		try{
			   
			   //Class.forName("com.mysql.jdbc.Driver");
			   
			    //  System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			   
			      //System.out.println("Creating statement...");
			      String sql = "update student set approved = 1 where studentId = "+id;

			      stmt = conn.prepareStatement(sql);
			      if(stmt.execute())
			    	  System.out.println("There was some error.");
			      else
			    	  System.out.println(" approved.");
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
	}

}
