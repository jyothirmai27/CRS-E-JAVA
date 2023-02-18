/**
 * 
 */
package com.signify.service;

import com.signify.bean.User;

/**
 * @author BHAVISH
 *
 */
public interface UserLoginInterface {
	


	
	public void login(User user);
	public void logout(String userId, String password);
	public String getDetails();

}
