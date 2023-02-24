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
import com.signify.exception.CourseNotAssignedToProfessorException;
import com.signify.exception.NoApprovedStudentsException;
import com.signify.exception.StudentNotApprovedException;
import com.signify.exception.StudentNotFoundForApprovalException;
import com.signify.exception.UserNotFoundException;
import com.signify.helper.IDs;
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
			      stmt.setInt(5, 0);
			      stmt.setString(6, student.getBatch());
			      stmt.setString(7, student.getPhoneNumber());
			      stmt.setInt(8, 0);
			      stmt.setInt(9, Integer.parseInt(student.getsemester()));
			      
			      stmt.executeUpdate();
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      //e.printStackTrace();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			     e.printStackTrace();
			   }
	}

	@Override
	public void delete(String studentId) {
		// TODO Auto-generated method stub
			
		   try{
			    conn = DBUtils.getConnection();
		      stmt = conn.prepareStatement(SQLConstants.DELETE_STUDENT + studentId);
	           stmt.executeUpdate();
		     
		      stmt.close();
		      //
		   }catch(SQLException e){
		      //Handle errors for JDBC
		      //e.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		     // e.printStackTrace();
		   }
	}

	@Override
	public void update(String query) {
		// TODO Auto-generated method stub
		try{
			 conn = DBUtils.getConnection();
			      stmt = conn.prepareStatement(SQLConstants.UPDATE_STUDENT_DETAILS+ query);
			      stmt.executeUpdate();
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      //e.printStackTrace();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			      //e.printStackTrace();
			   }
		
	}

	@Override
	public void view() throws NoApprovedStudentsException {
		// TODO Auto-generated method stub
		 try{
			  conn = DBUtils.getConnection();

			      stmt = conn.prepareStatement(SQLConstants.VIEW_ENROLLED_STUDENTS);
			      ResultSet rs = stmt.executeQuery();
			      
			    	  System.out.println("Id \t\t Name \t\t Branch ");
			    	  boolean flag = true;
				      while(rs.next()){
				    	  flag = false;
					       	int studentId = rs.getInt("studentId");
					         String name1 = rs.getString("studentName");
					         String branch = rs.getString("branchName");
					         System.out.println( Integer.toString(studentId)+"\t\t" + name1+"\t\t" + branch);
					      }
			     if (flag)
			    	 throw new NoApprovedStudentsException();
			    	  
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      //e.printStackTrace();
				   throw new NoApprovedStudentsException();
			   }catch(Exception e){ 	
				  
					   
			      //e.printStackTrace();
			   }
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
				      //
				      
			     
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      //e.printStackTrace();
				   throw new StudentNotFoundForApprovalException();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			     // e.printStackTrace();
			      throw new StudentNotFoundForApprovalException();
			   }
	}

	public void registered(String userId) {
		try{
			 conn = DBUtils.getConnection();
			      stmt = conn.prepareStatement(SQLConstants.REGISTRATION_AFTER_PAYMENT+ userId);
			      stmt.executeUpdate();
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      //e.printStackTrace();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			      //e.printStackTrace();
			   }
	}
	@Override
	public void approve(String id) throws StudentNotFoundForApprovalException, UserNotFoundException{
		// TODO Auto-generated method stub
		try{
			   
			 conn = DBUtils.getConnection();

			      stmt = conn.prepareStatement(SQLConstants.UPDATE_STUDENT + id);
			      if(stmt.execute())
			    	  throw new UserNotFoundException(id);
				      stmt.close();
				      //
				      
			     
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			     //e.printStackTrace();
				   throw new UserNotFoundException(id);
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			      //e.printStackTrace();
			      throw new UserNotFoundException(id);
			   }
	}

	@Override
	public int getSem(String userId) {
		// TODO Auto-generated method stub
		int sem = 0;
		try{
			 conn = DBUtils.getConnection();
			 stmt = conn.prepareStatement(SQLConstants.GET_SEMESTER+userId);
			      ResultSet rs = stmt.executeQuery();
			     
			      if (rs.next()) 
		               sem = rs.getInt("semester");
		                	 
			      
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      e.printStackTrace();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			     // e.printStackTrace();
			   }
		
		return sem;
	}

}
