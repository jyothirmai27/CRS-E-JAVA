/**
 * 
 */
package com.signify.exception;

/**
 * @author BHAVISH
 *
 */
public class AdminDoesntExistException extends Exception{

	public AdminDoesntExistException() {
		System.out.println("This user ID does not have admin access.");
	}
}
