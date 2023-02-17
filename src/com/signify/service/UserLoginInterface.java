/**
 * 
 */
package com.signify.service;

/**
 * @author BHAVISH
 *
 */
public interface UserLoginInterface {
	


	
	public void login(String userId, String password, String role);
	public void logout(String userId, String password);
	public String getDetails();

}
