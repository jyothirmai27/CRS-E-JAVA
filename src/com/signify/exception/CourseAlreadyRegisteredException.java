/**
 * 
 */
package com.signify.exception;

/**
 * @author BHAVISH
 *
 */
public class CourseAlreadyRegisteredException extends Exception{

	/**
	 * 
	 */
	public CourseAlreadyRegisteredException() {
		// TODO Auto-generated constructor stub
		super();
		System.out.println("This course has already been added.");
	}

}
