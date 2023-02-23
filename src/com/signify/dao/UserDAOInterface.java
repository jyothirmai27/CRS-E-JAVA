package com.signify.dao;

import com.signify.bean.User;
import com.signify.exception.NoProfessorInDatasetException;
import com.signify.exception.StudentNotFoundForApprovalException;
import com.signify.exception.UserNotFoundException;

public interface UserDAOInterface {
	
	public int add(User user, int role);
	public void update(String quer);
	public void updatePassword(String userId, String password);
	public void delete(String userId) throws UserNotFoundException;
	public int authenticate(String password,String userId);
	public void getUnapproved() throws StudentNotFoundForApprovalException;
	public void printProfessors() throws NoProfessorInDatasetException;
	public int getRole(String userId);
	public int count();
	public void updateStudent(int userId) throws UserNotFoundException;
	public void approveAll() throws StudentNotFoundForApprovalException;

}
