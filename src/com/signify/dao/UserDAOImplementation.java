/**
 * 
 */
package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.signify.bean.User;
import com.signify.helper.IDs;

/**
 * @author BHAVISH
 *
 */
public class UserDAOImplementation implements UserDAOInterface{

		Connection conn = null;
	   PreparedStatement stmt = null;
	@Override
	public int add(User user, int role) {
		// TODO Auto-generated method stub
		int userId = count()+1;
		   try{
			   			   
			   //Class.forName("com.mysql.jdbc.Driver");
			   
			    //  System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			   
			      //System.out.println("Creating statement...");
			      String sql="insert into user values(?,?,?,?)";
			      stmt = conn.prepareStatement(sql);
			   
			      //int userid=Integer.parseInt(user.getUserId());
			      
			      String name=user.getName();
			      String password=user.getPassword();
			      
			      stmt.setInt(1, userId); 
			      stmt.setString(2,name);
			      stmt.setString(3, password);
			      stmt.setInt(4, role);
			      
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
			   }//end try
		   return userId;
	}

	@Override
	public void update(String query) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int authenticate(String passwordUser, String userId) {
		// TODO Auto-generated method stub
		
		   try{
			   			   
			   //Class.forName("com.mysql.jdbc.Driver");
			   
			    //  System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			   
			      //System.out.println("Creating statement...");
			      String sql = "select password from user where userId = " + Integer.parseInt(userId) ;
			      
			      stmt = conn.prepareStatement(sql);
			      //stmt.setInt(1, Integer.parseInt(userId)); 
			      ResultSet rs = stmt.executeQuery(sql);
			      String password;
			      int role = 0;
			      if (rs.next()) {
		                 password = rs.getString("password");
		                 if(passwordUser.equals(password))
		                	 role = getRole(userId);
		                 else 
		                	 role = 99999;
			      }
			      System.out.println("=================================");
			      stmt.close();
			      conn.close();
			      return role;
			      
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
			   }//end try
		   return 9;
	}
	

	@Override
	public void getUnapproved() {
		// TODO Auto-generated method stub
		
		   try{
			   			   
			   //Class.forName("com.mysql.jdbc.Driver");
			   
			    //  System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			   
			      //System.out.println("Creating statement...");
			      String sql = "SELECT name, studentId FROM user WHERE role_id = 4";

			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);

			      while(rs.next()){
				         //Retrieve by column name
				       
				         String name1 = rs.getString("name");
				         int studentid = rs.getInt("studentId");
				         //Display values
				         System.out.println("Id : "+Integer.toString(studentid)+" Name : " + name1);
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
			   }//end try
	}
	
	public void approveAll() {
		try{
			   
			   //Class.forName("com.mysql.jdbc.Driver");
			   
			    //  System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			   
			      //System.out.println("Creating statement...");
			      String sql = "update user set role = 2 where userId = (SELECT userId FROM user WHERE role_id = 4)";

			      stmt = conn.prepareStatement(sql);
			      if(stmt.execute())
			    	  System.out.println("approved");
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
			   }//end try
	}
	
	@Override
	public void printProfessors() {
		// TODO Auto-generated method stub
		
		   try{
			   			   
			   //Class.forName("com.mysql.jdbc.Driver");
			   
			    //  System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			   
			      //System.out.println("Creating statement...");
			      String sql = "SELECT name FROM user WHERE role_id = 3";

			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);
			      System.out.println("Professor :");
			      while(rs.next()){
				         //Retrieve by column name
				       
				         String name1 = rs.getString("name");
				         //Display values
				         System.out.println("Name : " + name1);
				      }
			      System.out.println("=================================");
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
			   }//end try
	}

	@Override
	public int getRole(String userId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		   PreparedStatement stmt = null;
		   try{
			   			   
			   //Class.forName("com.mysql.jdbc.Driver");
			   
			    //  System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			   
			      //System.out.println("Creating statement...");
			      String sql = "select role_id from user where userId = " + Integer.parseInt(userId) ;
			      
			      stmt = conn.prepareStatement(sql);
			      System.out.println(Integer.parseInt(userId));
			      //stmt.setInt(1, Integer.parseInt(userId)); 
			      ResultSet rs = stmt.executeQuery(sql);
			      
			      int role = 0;
			      if (rs.next()) {
		                 role = rs.getInt("role_id");
		                //System.out.println("The password for user " + password);
		                	 
		            } else {
		            	role = 5;
		            }
			      System.out.println("=================================");
			      stmt.close();
			      conn.close();
			      return role;
			      
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
			   }//end try
		   return 9;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		
		int countId = 1;
			try{
			      conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			      
			      String sql = "SELECT COUNT(*) AS total FROM user";

			      stmt = conn.prepareStatement(sql);
			       ResultSet rs = stmt.executeQuery(sql);
			       countId = rs.getInt("total");
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
			   }//end try
		
		return countId;
	}

	@Override
	public void updateStudent(int userID) {
		// TODO Auto-generated method stub'
		  try{
  			   
			   //Class.forName("com.mysql.jdbc.Driver");
			   
			    //  System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			   
			      //System.out.println("Creating statement...");
			      String sql="update user set role = 2 where studentId = "+Integer.toString(userID);
			      stmt = conn.prepareStatement(sql);
			      if(stmt.execute())
			    	  System.out.println("approved");
			      else
			    	  System.out.println("There was some error.");
			      //stmt.executeUpdate();
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
			   }//end try
		
	}
	

}
