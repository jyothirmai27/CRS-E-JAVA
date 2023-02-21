package com.signify.dao;

import com.signify.bean.User;

public interface UserDAOInterface {
	
	public int add(User user, int role);
	public void update(String quer);
	public void updatePassword(String userId, String password);
	public void delete(String userId);
	public int authenticate(String password,String userId);
	public void getUnapproved();
	public void printProfessors();
	public int getRole(String userId);
	public int count();
	public void updateStudent(int userId);
	public void approveAll();

}
