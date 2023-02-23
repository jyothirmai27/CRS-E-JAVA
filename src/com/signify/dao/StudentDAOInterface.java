/**
 * 
 */
package com.signify.dao;

import com.signify.bean.Student;
import com.signify.exception.NoApprovedStudentsException;
import com.signify.exception.StudentNotFoundForApprovalException;
import com.signify.exception.UserNotFoundException;

/**
 * @author BHAVISH
 *
 */
public interface StudentDAOInterface {
	
	public void add(int id, Student student);
	public void delete(String query);
	public void update(String query);
	public void view() throws NoApprovedStudentsException;
	public void approveAll()throws StudentNotFoundForApprovalException;
	public void approve(String id)throws StudentNotFoundForApprovalException, UserNotFoundException;
	public void registered(String userId);
	public int getSem(String userId);
}
