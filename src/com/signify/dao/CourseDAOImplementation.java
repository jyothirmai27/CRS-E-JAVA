/**
 * 
 */
package com.signify.dao;

import com.signify.bean.Course;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.signify.helper.*;
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
			conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			String sql="insert into course values(?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, course.getCourseCode());
			stmt.setString(2,course.getCourseName());
			stmt.setString(3, course.getDepartmentName());
			stmt.setString(4,course.getProfessorName() );
			stmt.setString(5, course.getSemester());
			stmt.setInt(6, course.getEnrolledStudentCount());
			stmt.executeUpdate();
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
	public void remove(String courseCode) {
		// TODO Auto-generated method stub
		try
		{
			  conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
		      String sql="delete from student where userid=?";
		      stmt = conn.prepareStatement(sql);
		      stmt.setInt(1, Integer.parseInt(courseCode));
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
