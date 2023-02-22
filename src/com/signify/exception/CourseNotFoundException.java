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
		 System.out.println("Invalid CourseCode "+courseCode);
	}

}
