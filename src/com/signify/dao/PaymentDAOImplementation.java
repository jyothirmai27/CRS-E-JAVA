/**
 * 
 */
package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.signify.bean.Payment;
import com.signify.utils.DBUtils;

/**
 * @author BHAVISH
 *
 */
public class PaymentDAOImplementation implements PaymentDAOInterface {

	 Connection conn = null;
	 PreparedStatement stmt = null;
	   
	@Override
	public void add(String userId, Payment payment) {
		// TODO Auto-generated method stub

		   try{
			      conn = DBUtils.getConnection();
			      String sql="insert into payment(student, upiId, chequeNumber) values(?,?,?)";
			      stmt = conn.prepareStatement(sql);
			   
			      stmt.setInt(1, Integer.parseInt(payment.getStudentId()));
			      stmt.setString(2, payment.getUpiId());
			      stmt.setString(3, payment.getChequeNumber());
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

}
