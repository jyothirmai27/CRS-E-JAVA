/**
 * 
 */
package com.signify.exception;

/**
 * @author BHAVISH
 *
 */
public class CourseNotFoundException extends Exception {

	public CourseNotFoundException (String courseCode)
	{
		super();
		 System.out.println("Invalid CourseCode "+courseCode);
	}

}
