/**
 * 
 */
package com.signify.exception;

/**
 * @author BHAVISH
 *
 */
public class StudentNotApprovedException extends Exception{
	public  StudentNotApprovedException (String studentName)
	{
		 System.out.println("Student Not Approved "+studentName);
	}
}
