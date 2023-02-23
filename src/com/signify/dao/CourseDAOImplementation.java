/**
 * 
 */
package com.signify.dao;

import com.signify.bean.Course;
import com.signify.constants.SQLConstants;
import com.signify.exception.CourseNotFoundException;
import com.signify.exception.NoCourseException;
import com.signify.helper.IDs;
import com.signify.utils.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author BHAVISH
 *
 */
public class CourseDAOImplementation implements CourseDAOInterface {

	
	Connection conn=null;
	PreparedStatement stmt=null;
	
	@Override
	public void add(Course course) {
		// TODO Auto-generated method stub
		try
		{
			conn = DBUtils.getConnection();
			stmt=conn.prepareStatement(SQLConstants.ADD_COURSE);
			stmt.setString(1, course.getCourseCode());
			stmt.setString(2,course.getCourseName());
			stmt.setString(3, course.getDepartmentName());
			stmt.setString(4, course.getSemester());

			if(stmt.execute())
				System.out.println("Course Already present.");
			stmt.close();
			//
		}
		catch(SQLException e)
		{
			//e.printStackTrace();
			System.out.println("Course Already present.");
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}
	}

	@Override
	public void remove(String courseCode) throws CourseNotFoundException{
		// TODO Auto-generated method stub
		try
		{
			  conn = DBUtils.getConnection();
		      
		      stmt = conn.prepareStatement(SQLConstants.DELETE_COURSE);
		      stmt.setString(1, courseCode);
		      ResultSet rs = stmt.executeQuery();
	           if(rs.next())
	        	   throw new CourseNotFoundException(courseCode);
		     
		      stmt.close();
		      //
		   }catch(SQLException e){
		      //Handle errors for JDBC
		      //e.printStackTrace();

        	   throw new CourseNotFoundException(courseCode);
		   }catch(Exception e){
		      //Handle errors for Class.forName
		     // e.printStackTrace();
		   }
	}

	@Override
	public void update(String query) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void view() throws NoCourseException{
		// TODO Auto-generated method stub
		 try{
			 	  conn = DBUtils.getConnection();
			 	   //System.out.println(SQLConstants.VIEW_COURSES);
			 	  stmt = conn.prepareStatement(SQLConstants.VIEW_COURSES);
			      ResultSet rs = stmt.executeQuery(SQLConstants.VIEW_COURSES);
			    
			      System.out.println("Course code \t Course Name \t Department \t Semester ");
			      boolean flag = true;

				      while(rs.next()){
					         //Retrieve by column name
				    	  flag = false;
					       	 String courseCode = rs.getString("courseCode");
					         String courseName = rs.getString("courseName");
					         String branch = rs.getString("departmentname");
					         String sem = rs.getString("semester");
					         //Display values
					         System.out.println(courseCode+"\t\t" + courseName+"\t\t" + branch+"\t\t" +sem);
					      }
				      if(flag)
			    	  throw new NoCourseException();
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      ////e.printStackTrace();
				   throw new NoCourseException();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			     // e.printStackTrace();
			   }
	}

}
