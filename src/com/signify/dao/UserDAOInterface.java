package com.signify.dao;

import com.signify.bean.User;

public interface UserDAOInterface {
	
	public void add(User user, int role);
	public void update(String quer);
	public void delete(String userId);
	public String getPassword(String userId);
	public void getUnapproved();
	public void printProfessors();

}
