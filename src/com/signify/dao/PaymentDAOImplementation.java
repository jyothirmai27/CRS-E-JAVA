/**
 * 
 */
package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.signify.bean.Payment;
import com.signify.constants.SQLConstants;
import com.signify.helper.IDs;
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
			      stmt = conn.prepareStatement(SQLConstants.ADD_PAYMENT);
			   
			      stmt.setInt(1, Integer.parseInt(payment.getStudentId()));
			      stmt.setString(2, payment.getUpiId());
			      stmt.setString(3, payment.getChequeNumber());
			      stmt.setString(4, payment.getReferenceId());
			      stmt.executeUpdate();
			      stmt.close();
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      //e.printStackTrace();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			     // e.printStackTrace();
			   }
	}

}
