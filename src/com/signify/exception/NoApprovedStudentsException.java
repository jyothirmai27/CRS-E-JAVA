/**
 * 
 */
package com.signify.exception;

/**
 * @author BHAVISH
 *
 */
public class NoApprovedStudentsException extends Exception {

	/**
	 * 
	 */
	public NoApprovedStudentsException() {
		// TODO Auto-generated constructor stub
		super();
		System.out.println("There are no approved students yet.");
	}

}
