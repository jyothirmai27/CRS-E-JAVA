/**
 * 
 */
package com.signify.dao;

import com.signify.bean.Course;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			String sql="insert into course values(?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, course.getCourseCode());
			stmt.setString(2,course.getCourseName());
			stmt.setString(3, course.getDepartmentName());
			stmt.setString(4, course.getSemester());

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
	public void remove(String courseCode) {
		// TODO Auto-generated method stub
		try
		{
			  conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
		      String sql="delete from course where courseCode="+courseCode;
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
		   }//end try
	}

	@Override
	public void update(String query) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void view() {
		// TODO Auto-generated method stub
		 try{
			 conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			   
			      //System.out.println("Creating statement...");
			      String sql = "SELECT * FROM course";

			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);
			      System.out.println("Course code \t Course Name \t Department \t Semester ");
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

}
