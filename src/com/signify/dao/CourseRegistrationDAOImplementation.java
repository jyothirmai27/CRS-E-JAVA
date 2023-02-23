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
import com.signify.exception.PaymentDoneCourseNotAddedException;
import com.signify.exception.UserNotFoundException;
import com.signify.helper.IDs;
import com.signify.utils.DBUtils;

public class CourseRegistrationDAOImplementation implements CourseRegistrationDAOInterface{

	Connection conn=null;
	PreparedStatement stmt=null;
	
	@Override
	public void addCourse(String student, String course) throws CourseAlreadyRegisteredException, PaymentDoneCourseNotAddedException{
		// TODO Auto-generated method stub
		if(getPaymentstatus(student)) {
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
				//
			}
			catch(SQLException e)
			{
				//e.printStackTrace();
				throw new CourseAlreadyRegisteredException();
			}
			catch(Exception e)
			{
				//e.printStackTrace();
			}
		}
		else
			throw new PaymentDoneCourseNotAddedException();
	}

	@Override
	public void dropCourse(String student, String course) throws CourseNotInRegisteredException, PaymentDoneCourseNotAddedException{
		// TODO Auto-generated method stub
		if(getPaymentstatus(student)) {
			
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
			      //
			   }catch(SQLException e){
			      //Handle errors for JDBC
			      //e.printStackTrace();

	        	   throw new CourseNotInRegisteredException();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      //e.printStackTrace();
			   }
			
		}else
			throw new PaymentDoneCourseNotAddedException();
	}

	@Override
	public void viewCourses(String student)throws NoCourseRegisteredException {
		// TODO Auto-generated method stub
		 try{
			 	   conn = DBUtils.getConnection();
			      String sql = "SELECT * FROM course WHERE courseCode = (SELECT courseCode FROM course_registration where studentId = \""+student +"\")";

			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);
			      System.out.println("Course code \t\t Course Name \t\t Department \t\t Semester ");
			      boolean flag = true;
			    	  while(rs.next()){
			    		  	flag = false;
					       	 String courseCode = rs.getString("courseCode");
					         String courseName = rs.getString("courseName");
					         String branch = rs.getString("departmentname");
					         String sem = rs.getString("semester");
					         //Display values
					         System.out.println(courseCode+"\t\t" + courseName+"\t\t" + branch+"\t\t" +sem);
					      }
			      
			      if(flag)
			    	  throw new NoCourseRegisteredException();
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      //e.printStackTrace();

			    	  throw new NoCourseRegisteredException();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			     // e.printStackTrace();
			   }
	}

	@Override
	public void viewStudents(String course) throws NoStudentsRegisteredForCourseException{
		// TODO Auto-generated method stub
		 try{
			  conn = DBUtils.getConnection();
			   
			      String sql = "SELECT studentId, studentName FROM students WHERE studentId = (SELECT studentId FROM course_registration where courseCode = \""+course +"\")";

			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);
			      System.out.println("Id \t\t Name");
			      boolean flag = true;
		    	  while(rs.next()){
		    		  	flag = false;
					       	 String id = rs.getString("studentId");
					         String name = rs.getString("studentName");
					         //Display values
					         System.out.println(id+"\t\t" + name);
					      }
			      
		    	  if(flag)
			    	  throw new NoStudentsRegisteredForCourseException();
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      //e.printStackTrace();
			    	  throw new NoStudentsRegisteredForCourseException();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			      //e.printStackTrace();
			   }
	}

	@Override
	public void addGrade(String student, String course, String grade) throws UserNotFoundException {
		// TODO Auto-generated method stub
		 try{
			  conn = DBUtils.getConnection();
			      String sql = "UPDATE course_registration SET grade = \""+grade+"\" WHERE studentId = \""+student+"\" and courseCode = \""+course+"\"";

			      stmt = conn.prepareStatement(sql);
			      if(stmt.execute())
			    	  throw new UserNotFoundException(student);
			      else
			    	  System.out.println("Grade added.");
			      
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      //e.printStackTrace();

			    	  throw new UserNotFoundException(student);
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			     // e.printStackTrace();
			   }
	}

	@Override
	public boolean getPaymentstatus(String studentId) {
		// TODO Auto-generated method stub
		boolean status = true;
		try{
			  conn = DBUtils.getConnection();
			   
			      String sql = "SELECT registered FROM students WHERE studentId = \""+studentId +"\")";

			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);
			      if(rs.next()) {
			    	  if(rs.getInt("registered")== 1)
			    		  status = false;
			      }
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      //e.printStackTrace();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			     // e.printStackTrace();
			   }
		return status;
	}

}
