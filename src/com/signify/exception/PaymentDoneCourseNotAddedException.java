/**
 * 
 */
package com.signify.exception;

/**
 * @author BHAVISH
 *
 */
public class PaymentDoneCourseNotAddedException extends Exception{

	/**
	 * 
	 */
	public PaymentDoneCourseNotAddedException() {
		// TODO Auto-generated constructor stub
		super();
		System.out.println("You have already registered for courses.");
	}

}
