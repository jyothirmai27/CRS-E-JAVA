package com.signify.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.signify.constants.SQLConstants;
import com.signify.exception.CourseAlreadyRegisteredException;
import com.signify.exception.CourseNotInRegisteredException;
import com.signify.exception.NoCourseRegisteredException;
import com.signify.exception.NoStudentsRegisteredForCourseException;
import com.signify.exception.UserNotFoundException;
import com.signify.utils.DBUtils;

public class CourseRegistrationDAOImplementation implements CourseRegistrationDAOInterface{

	Connection conn=null;
	PreparedStatement stmt=null;
	
	@Override
	public void addCourse(String student, String course) throws CourseAlreadyRegisteredException{
		// TODO Auto-generated method stub
		try
		{
			conn = DBUtils.getConnection();
			
			stmt=conn.prepareStatement(SQLConstants.ADD_REGISTERED_COURSE);
			stmt.setString(1, student);
			stmt.setString(2,course);
			if(stmt.execute())
				throw new CourseAlreadyRegisteredException();
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
	public void dropCourse(String student, String course) throws CourseNotInRegisteredException {
		// TODO Auto-generated method stub
		try
		{
			  conn = DBUtils.getConnection();
		      stmt = conn.prepareStatement(SQLConstants.DELETE_REGISTERED_COURSE);
	            // execute the delete statement
		      stmt.setString(1, course);
		      stmt.setInt(0, Integer.parseInt(student));
	           if(stmt.execute())
	        	   throw new CourseNotInRegisteredException();
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
	public void viewCourses(String student)throws NoCourseRegisteredException {
		// TODO Auto-generated method stub
		 try{
			 	  conn = DBUtils.getConnection();
			      String sql = "SELECT * FROM course WHERE courseCode = (SELECT courseCode FROM courseregistration where studentId = \""+student +"\")";

			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);
			      System.out.println("Course code \t\t Course Name \t\t Department \t\t Semester ");
			      if(rs.next()) {
			    	  while(rs.next()){
					         //Retrieve by column name
					       	 String courseCode = rs.getString("courseCode");
					         String courseName = rs.getString("courseName");
					         String branch = rs.getString("departmentname");
					         String sem = rs.getString("semester");
					         //Display values
					         System.out.println(courseCode+"\t\t" + courseName+"\t\t" + branch+"\t\t" +sem);
					      }
			      }
			      else
			    	  throw new NoCourseRegisteredException();
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
	public void viewStudents(String course) throws NoStudentsRegisteredForCourseException{
		// TODO Auto-generated method stub
		 try{
			 conn = DBUtils.getConnection();
			   
			      String sql = "SELECT studentId, studentName FROM student WHERE studentId = (SELECT studentId FROM courseregistration where courseCode = \""+course +"\")";

			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);
			      System.out.println("Id \t\t Name");
			      if(rs.next()) {
			    	  while(rs.next()){
					         //Retrieve by column name
					       	 String id = rs.getString("studentId");
					         String name = rs.getString("studentName");
					         //Display values
					         System.out.println(id+"\t\t" + name);
					      }
			      }
			      else
			    	  throw new NoStudentsRegisteredForCourseException();
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
	public void addGrade(String student, String course, String grade) throws UserNotFoundException {
		// TODO Auto-generated method stub
		 try{
			 conn = DBUtils.getConnection();
			      String sql = "UPDATE  courseregistration SET grade = \""+grade+"\" WHERE studentId = \""+student+"\" and courseCode = \""+course+"\"";

			      stmt = conn.prepareStatement(sql);
			      if(stmt.execute())
			    	  throw new UserNotFoundException(student);
			      else
			    	  System.out.println("Grade added.");
			      
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
