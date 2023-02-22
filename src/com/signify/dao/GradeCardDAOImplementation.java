package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.signify.utils.DBUtils;

public class GradeCardDAOImplementation implements GradeCardDAOInterface{

	Connection conn = null;
	PreparedStatement stmt = null;
	   

	@Override
	public void viewgrades(String userId,Double cpi) {
		// TODO Auto-generated method stub
		try{
				  conn = DBUtils.getConnection();
			      String sql="select courseCode,grade from courseregistration where studentId="+userId;
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
	public void update(String userId) {
		// TODO Auto-generated method stub
		try{
				  conn = DBUtils.getConnection();
			      String sql="insert into gradecard values(?,?,?)";
			      stmt = conn.prepareStatement(sql);
			      
			      stmt.setString(1, userId); 
			      stmt.setBigDecimal(2, null);
			      stmt.setInt(3, 0);
			      
			      stmt.executeUpdate();
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
	public void view(String userId) {
		// TODO Auto-generated method stub
		try{
				conn = DBUtils.getConnection();
			      String sql="select cpi,visible from gradecard where student = "+userId;
			      stmt = conn.prepareStatement(sql);
			      
			      stmt = conn.prepareStatement(sql);
			      //stmt.setInt(1, Integer.parseInt(userId)); 
			      ResultSet rs = stmt.executeQuery(sql);
			      
			      if (rs.next()) 
			    	  if(rs.getInt("visible")==0)
			    		  System.out.println("Grade Card has not been released yet.");
		                 else 
		                	 viewgrades(userId,rs.getDouble("cpi"));
		                	 
			      else
			    	  System.out.println("There was some error.");
			      
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
	public void generate() {
		// TODO Auto-generated method stub
		try{
				conn = DBUtils.getConnection();
			      String sql="update gradecard set visible = 1";
			      stmt = conn.prepareStatement(sql);
			      if(stmt.execute())
			    	  System.out.println("There was some error.");
			      else
			    	  System.out.println("Grade Card generated.");
			      
			      
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
