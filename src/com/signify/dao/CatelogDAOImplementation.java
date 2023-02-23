/**
 * 
 */
package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.signify.constants.SQLConstants;
import com.signify.exception.CourseNotAssignedToProfessorException;
import com.signify.exception.CourseNotFoundException;
import com.signify.exception.NoCourseException;
import com.signify.helper.IDs;
import com.signify.utils.DBUtils;

/**
 * @author BHAVISH
 *
 */
public class CatelogDAOImplementation implements CatelogDAOInterface {

	Connection conn=null;
	PreparedStatement stmt=null;
	
	@Override
	public void add(String profid, String courseCode) throws CourseNotFoundException{
		// TODO Auto-generated method stub
		try
		{
			 conn = DBUtils.getConnection();
			stmt=conn.prepareStatement(SQLConstants.ADD_CP_IN_CATELOG);
			stmt.setString(1, courseCode);
			stmt.setString(2,profid);
			if(stmt.execute())
				throw new CourseNotFoundException(courseCode);
			stmt.close();
			//
		}
		catch(SQLException e)
		{
			//e.printStackTrace();

			throw new CourseNotFoundException(courseCode);
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}
	}

	@Override
	public void remove(String courseCode) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		try
		{
			 conn = DBUtils.getConnection();
		     
		      stmt = conn.prepareStatement(SQLConstants.DELETE_CP_IN_CATELOG+courseCode);
	           if(stmt.execute())
	        	   throw new CourseNotFoundException(courseCode);
	           else
	        	   System.out.println("Course Deleted.");
		     
		      stmt.close();
		      //
		   }catch(SQLException e){
		      //Handle errors for JDBC
		      //e.printStackTrace();

        	   throw new CourseNotFoundException(courseCode);
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      //e.printStackTrace();
		   }
	}

	@Override
	public String getCourse(String prof)throws CourseNotAssignedToProfessorException {
		// TODO Auto-generated method stub
		 String course = "";
		try{
			 conn = DBUtils.getConnection();
			 stmt = conn.prepareStatement(SQLConstants.GET_COURSE+prof);
			      ResultSet rs = stmt.executeQuery(SQLConstants.GET_COURSE+prof);
			     
			      if (rs.next()) 
			    	  throw new CourseNotAssignedToProfessorException();
		          else 
		               course = rs.getString("course_code");
		                	 
			      
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      //e.printStackTrace();
			    	  throw new CourseNotAssignedToProfessorException();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			     // e.printStackTrace();
			   }
		
		
		return course;
	}

}
