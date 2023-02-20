package com.signify.dao;

import com.signify.bean.User;

public interface UserDAOInterface {
	
	public void add(User user);
	public void update(String quer);
	public void delete(String userId);
	public void getPassword(String userId);

}
