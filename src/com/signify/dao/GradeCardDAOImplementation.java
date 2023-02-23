package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.signify.constants.SQLConstants;
import com.signify.exception.NoCourseRegisteredException;
import com.signify.exception.UserNotFoundException;
import com.signify.helper.IDs;
import com.signify.utils.DBUtils;

public class GradeCardDAOImplementation implements GradeCardDAOInterface{

	Connection conn = null;
	PreparedStatement stmt = null;
	   

	@Override
	public void viewgrades(String userId,Double cpi) {
		// TODO Auto-generated method stub
		try{
				  conn = DBUtils.getConnection();
			      String sql="select courseCode,grade from course_registration where studentId= \""+userId +"\"";
			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);
			      System.out.println("Student id : " +userId);
			      System.out.println("Course \t Grade");
			      while(rs.next())
			      {
			    	  String course=rs.getString("courseCode");
			    	  String grade=rs.getString("grade");
			    	  System.out.println(course +"\t" +grade);
			    	  
			      }
			      System.out.println("CPI : "+Double.toString(cpi));
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			     // e.printStackTrace();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			      //e.printStackTrace();
			   }
		
	}

	@Override
	public void update(String userId) {
		// TODO Auto-generated method stub
		try{
				  conn = DBUtils.getConnection();
			      stmt = conn.prepareStatement(SQLConstants.UPDATE_GRADE_CARD);
			      
			      stmt.setString(1, userId); 
			      stmt.setBigDecimal(2, null);
			      stmt.setInt(3, 0);
			      
			      stmt.executeUpdate();
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      //e.printStackTrace();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			     // e.printStackTrace();
			   }
		
	}

	@Override
	public void view(String userId) throws NoCourseRegisteredException{
		// TODO Auto-generated method stub
		try{
				conn = DBUtils.getConnection();
				stmt = conn.prepareStatement(SQLConstants.VIEW_REPORT_CARD+userId);
			      ResultSet rs = stmt.executeQuery(SQLConstants.VIEW_REPORT_CARD+userId);
			      
			      if (rs.next()) 
			    	  if(rs.getInt("visible")==0)
			    		  System.out.println("Grade Card has not been released yet.");
		                 else 
		                	 viewgrades(userId,rs.getDouble("cpi"));
			      else
			    	  throw new NoCourseRegisteredException();
			      
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      //e.printStackTrace();

			    	  throw new NoCourseRegisteredException();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			      //e.printStackTrace();
			   }
		
		
	}

	@Override
	public void generate() throws NoCourseRegisteredException {
		// TODO Auto-generated method stub
		try{
			conn = DBUtils.getConnection();
			      stmt = conn.prepareStatement(SQLConstants.GENERATE_REPORT_CARD);
			      //if(stmt.execute())
			    	 // throw new NoCourseRegisteredException();
			   	      
			      stmt.executeUpdate();
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      //e.printStackTrace();

			    	  throw new NoCourseRegisteredException();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			     // e.printStackTrace();
			   
			   }
	}

	
}
