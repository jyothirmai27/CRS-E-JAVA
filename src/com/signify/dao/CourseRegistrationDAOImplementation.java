package com.signify.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.signify.helper.*;

import com.signify.helper.IDs;

public class CourseRegistrationDAOImplementation implements CourseRegistrationDAOInterface{

	Connection conn=null;
	PreparedStatement stmt=null;
	
	@Override
	public void addCourse(String student, String course) {
		// TODO Auto-generated method stub
		try
		{
			conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			String sql="insert into courseregistration(studentId, courseCode) values(?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, student);
			stmt.setString(2,course);
			if(stmt.execute())
				System.out.println("There was some error.");
			else
				System.out.println("Course added.");
			stmt.close();
			conn.close();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt!=null)
					stmt.close();
			}
			catch(SQLException se2)
			{
				
			}
			try
			{
				if(conn!=null)
					conn.close();
			}
			catch(SQLException Se)
			{
				Se.printStackTrace();
			}
		}
	}

	@Override
	public void dropCourse(String student, String course) {
		// TODO Auto-generated method stub
		try
		{
			  conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
		      String sql="delete from courseregistration where courseCode="+course;
		      stmt = conn.prepareStatement(sql);
	            // execute the delete statement
	           if(stmt.execute())
	        	   System.out.println("There was some error.");
	           else
	        	   System.out.println("Course Deleted.");
		     
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
		   }
	}

	@Override
	public void viewCourses(String student) {
		// TODO Auto-generated method stub
		 try{
			 conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			   
			      //System.out.println("Creating statement...");
			      String sql = "SELECT * FROM course WHERE courseCode = (SELECT courseCode FROM courseregistration where studentId = "+student +")";

			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);
			      System.out.println("Course code \t\t Course Name \t\t Department \t\t Semester ");
			      while(rs.next()){
				         //Retrieve by column name
				       	 String courseCode = rs.getString("courseCode");
				         String courseName = rs.getString("courseName");
				         String branch = rs.getString("departmentname");
				         String sem = rs.getString("semester");
				         //Display values
				         System.out.println(courseCode+"\t\t" + courseName+"\t\t" + branch+"\t\t" +sem);
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
			   }
	}

	@Override
	public void viewStudents(String course) {
		// TODO Auto-generated method stub
		 try{
			 conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			   
			      //System.out.println("Creating statement...");
			      String sql = "SELECT studentId, studentName FROM student WHERE studentId = (SELECT studentId FROM courseregistration where courseCode = "+course +")";

			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);
			      System.out.println("Id \t\t Name");
			      while(rs.next()){
				         //Retrieve by column name
				       	 String id = rs.getString("studentId");
				         String name = rs.getString("studentName");
				         //Display values
				         System.out.println(id+"\t\t" + name);
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
			   }
	}

}
