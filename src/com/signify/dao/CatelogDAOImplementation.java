/**
 * 
 */
package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.signify.helper.IDs;

/**
 * @author BHAVISH
 *
 */
public class CatelogDAOImplementation implements CatelogDAOInterface {

	Connection conn=null;
	PreparedStatement stmt=null;
	
	@Override
	public void add(String profid, String courseCode) {
		// TODO Auto-generated method stub
		try
		{
			conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			String sql="insert into catelog(course_code, professorId) values(?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, courseCode);
			stmt.setString(2,profid);
			if(stmt.execute())
				System.out.println("There was some error.");
			else
				System.out.println("Course assigned.");
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
		      String sql="delete from catelog where course_code="+courseCode;
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

}
