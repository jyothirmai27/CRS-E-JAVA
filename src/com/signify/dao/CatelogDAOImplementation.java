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
	public String getCourse(String prof)throws CourseNotAssignedToProfessorException {
		// TODO Auto-generated method stub
		 String course = "";
		try{
			conn = DBUtils.getConnection();
			      
			      ResultSet rs = stmt.executeQuery(SQLConstants.GET_COURSE+prof);
			     
			      if (rs.next()) 
			    	  throw new CourseNotAssignedToProfessorException();
		          else 
		               course = rs.getString("course_code");
		                	 
			      
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
		
		
		
		return course;
	}

}
