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
import com.signify.utils.DBUtils;

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
		   try{conn = DBUtils.getConnection();
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
		
		   try{conn = DBUtils.getConnection();
			      String sql = "select name,password from user where userId = " + Integer.parseInt(userId) ;
			      
			      stmt = conn.prepareStatement(sql);
			      //stmt.setInt(1, Integer.parseInt(userId)); 
			      ResultSet rs = stmt.executeQuery(sql);
			      String password;
			      String name;
			      int role = 0;
			      if (rs.next()) {
		                 password = rs.getString("password");
		                 if(passwordUser.equals(password)) {
		                	 role = getRole(userId);
		                	 name = rs.getString("name");
		                	 System.out.print("\n      Hi "+name);
		                 }
		                 else 
		                	 role = 99999;
			      }
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
		
		   try{conn = DBUtils.getConnection();
			      String sql = "SELECT name, userId FROM user WHERE role_id = 4";

			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);
			      System.out.println("Id \t\t Name ");

			      while(rs.next()){
				         //Retrieve by column name
				       
				         String name1 = rs.getString("name");
				         int studentid = rs.getInt("userId");
				         //Display values
				         System.out.println(Integer.toString(studentid)+"\t\t" + name1);
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
		try{conn = DBUtils.getConnection();
			      String sql = "UPDATE user set role_id = 2 where userId = (SELECT studentId FROM student WHERE approved = 0)";

			      stmt = conn.prepareStatement(sql);
			      if(stmt.execute())
			    	  System.out.println("There was some error.");
			      else
			    	  System.out.print("Students have been ");
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
			   conn = DBUtils.getConnection();
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
			   			   
			   conn = DBUtils.getConnection();
			      String sql = "select role_id from user where userId = " + Integer.parseInt(userId) ;
			      
			      stmt = conn.prepareStatement(sql);
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
				conn = DBUtils.getConnection();
			      String sql = "SELECT COUNT(*) AS total FROM user";

			      stmt = conn.prepareStatement(sql);
			       ResultSet rs = stmt.executeQuery(sql);
			       if(rs.next())
			    	   countId = rs.getInt("total");
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
		
		return countId;
	}

	@Override
	public void updateStudent(int userID) {
		// TODO Auto-generated method stub'
		  try{ 
			  conn = DBUtils.getConnection();
			      String sql="update user set role = 2 where userId = "+Integer.toString(userID);
			      stmt = conn.prepareStatement(sql);
			      if(stmt.execute())
			    	  System.out.println("There was some error.");
			      else
			    	  System.out.println("approved.");
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

	@Override
	public void updatePassword(String userId, String password) {
		// TODO Auto-generated method stub
		try{
				conn = DBUtils.getConnection();
			      String sql="update user set password = \""+ password +"\" where userId = "+userId;
			      //System.out.println(sql);
			      stmt = conn.prepareStatement(sql);
			      if(stmt.execute())
			    	  System.out.println("There was some error.");
			      else
			    	  System.out.println("Password updated.");
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
