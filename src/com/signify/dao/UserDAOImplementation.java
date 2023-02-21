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

	@Override
	public void add(User user, int role) {
		// TODO Auto-generated method stub

		   Connection conn = null;
		   PreparedStatement stmt = null;
		   try{
			   			   
			   //Class.forName("com.mysql.jdbc.Driver");
			   
			    //  System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			   
			      //System.out.println("Creating statement...");
			      String sql="insert into user values(?,?,?,?)";
			      stmt = conn.prepareStatement(sql);
			   
			      int userid=Integer.parseInt(user.getUserId());
			      String name=user.getName();
			      String password=user.getPassword();
			      
			      stmt.setInt(1, userid); 
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
	public String getPassword(String userId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		   PreparedStatement stmt = null;
		   try{
			   			   
			   //Class.forName("com.mysql.jdbc.Driver");
			   
			    //  System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			   
			      //System.out.println("Creating statement...");
			      String sql = "select password from user where userId = " + Integer.parseInt(userId) ;
			      
			      stmt = conn.prepareStatement(sql);
			      System.out.println(Integer.parseInt(userId));
			      //stmt.setInt(1, Integer.parseInt(userId)); 
                  System.out.println("in1");
			      ResultSet rs = stmt.executeQuery(sql);
			      String password;
			      if (rs.next()) {
		                 password = rs.getString("password");
		                //System.out.println("The password for user " + password);
		            } else { password ="";
		                System.out.println("No password found for user ");
		            }
			      System.out.println("=================================");
			      stmt.close();
			      conn.close();
			      return password;
			      
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
	public void getUnapproved() {
		// TODO Auto-generated method stub
		Connection conn = null;
		   PreparedStatement stmt = null;
		   try{
			   			   
			   //Class.forName("com.mysql.jdbc.Driver");
			   
			    //  System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			   
			      //System.out.println("Creating statement...");
			      String sql = "SELECT name FROM user WHERE role_id = (?)";

			      stmt = conn.prepareStatement(sql);
			  
			      stmt.setInt(1, 4); 

			      ResultSet rs = stmt.executeQuery(sql);

			      while(rs.next()){
				         //Retrieve by column name
				       
				         String name1 = rs.getString("name");
				         //Display values
				         System.out.println(", Age: " + name1);
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

	@Override
	public void printProfessors() {
		// TODO Auto-generated method stub
		Connection conn = null;
		   PreparedStatement stmt = null;
		   try{
			   			   
			   //Class.forName("com.mysql.jdbc.Driver");
			   
			    //  System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(IDs.DB_URL,IDs.USER,IDs.PASS);
			   
			      //System.out.println("Creating statement...");
			      String sql = "SELECT name FROM user WHERE role_id =?";

			      stmt = conn.prepareStatement(sql);
			  
			      stmt.setInt(1, 3); 

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
	

}
