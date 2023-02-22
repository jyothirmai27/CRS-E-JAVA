/**
 * 
 */
package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.signify.bean.Student;
import com.signify.constants.SQLConstants;
import com.signify.exception.NoApprovedStudentsException;
import com.signify.exception.StudentNotApprovedException;
import com.signify.exception.StudentNotFoundForApprovalException;
import com.signify.utils.DBUtils;

/**
 * @author BHAVISH
 *
 */
public class StudentDAOImplementation implements StudentDAOInterface{

	Connection conn = null;
	PreparedStatement stmt = null;
	@Override
	public void add(int id, Student student) {
		// TODO Auto-generated method stub
	
		   try{
			      conn = DBUtils.getConnection();
			      stmt = conn.prepareStatement(SQLConstants.REGISTER_STUDENT);
			      String name=student.getStudentName();
			      stmt.setInt(1, id); 
			      stmt.setString(2,name);
			      stmt.setString(3, student.getAddress());
			      stmt.setString(4, student.getBranchName());
			      stmt.setString(5, student.getScholarshipId());
			      stmt.setString(6, student.getBatch());
			      stmt.setString(7, student.getPhoneNumber());
			      stmt.setInt(8, 0);
			      
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
			  // System.out.println("Goodbye!");
	}

	@Override
	public void delete(String studentId) {
		// TODO Auto-generated method stub
			
		   try{
			   conn = DBUtils.getConnection();
		      stmt = conn.prepareStatement(SQLConstants.DELETE_STUDENT + studentId);
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
		   //System.out.println("Student Removed!");
	}

	@Override
	public void update(String query) {
		// TODO Auto-generated method stub
		try{
			conn = DBUtils.getConnection();
			      stmt = conn.prepareStatement(SQLConstants.UPDATE_STUDENT_DETAILS+ query);
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
	public void view() throws NoApprovedStudentsException {
		// TODO Auto-generated method stub
		 try{
			 conn = DBUtils.getConnection();

			      stmt = conn.prepareStatement(SQLConstants.VIEW_ENROLLED_STUDENTS);
			      ResultSet rs = stmt.executeQuery(SQLConstants.VIEW_ENROLLED_STUDENTS);
			      if(rs.next()) {
			    	  System.out.println("Id \t\t Name \t\t Branch ");
				      while(rs.next()){
					       	int studentId = rs.getInt("studentId");
					         String name1 = rs.getString("studentName");
					         String branch = rs.getString("branchName");
					         System.out.println( Integer.toString(studentId)+"\t\t" + name1+"\t\t" + branch);
					      }
			      }
			      else
			    	  throw new NoApprovedStudentsException();
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
	public void approveAll() throws StudentNotFoundForApprovalException{
		// TODO Auto-generated method stub
		try{
				conn = DBUtils.getConnection();
			      stmt = conn.prepareStatement(SQLConstants.UPDATE_ALL_STUDENTS);
			      if(stmt.execute())
			    	  	throw new StudentNotFoundForApprovalException();
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
	public void approve(String id) throws StudentNotFoundForApprovalException{
		// TODO Auto-generated method stub
		try{
			   
			conn = DBUtils.getConnection();

			      stmt = conn.prepareStatement(SQLConstants.UPDATE_STUDENT + id);
			      if(stmt.execute())
			    	  throw new StudentNotFoundForApprovalException();
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
