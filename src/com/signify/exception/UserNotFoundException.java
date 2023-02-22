/**
 * 
 */
package com.signify.exception;

/**
 * @author BHAVISH
 *
 */
public class UserNotFoundException extends Exception {
	private String userName;

	public UserNotFoundException(String userId) {
		super(userId);
		this.userName = userId;
		System.out.println("Invalid UserID : " + userId);
	}
}
