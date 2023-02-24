/**
 * 
 */
package com.signify.validator;

import com.signify.dao.CourseRegistrationDAOImplementation;
import com.signify.dao.CourseRegistrationDAOInterface;
import com.signify.exception.NoCourseRegisteredException;
import com.signify.exception.RegistrationFailedException;

/**
 * @author GROUP-E-CRS-SIGNIFY
 *
 */
public class PaymentValidator {
	static CourseRegistrationDAOInterface coursesDataset = new CourseRegistrationDAOImplementation();
	/**
		Method to check whether the Student have selected all the necessary course for making payment 
		@return Exception if occurred
	
	**/
	public static boolean canMakePayment(String userId)	throws RegistrationFailedException, NoCourseRegisteredException{
		int courses = coursesDataset.countCourseStudent(userId);
		if(courses <6)
			throw new  RegistrationFailedException(" not having 6 courses. Please add courses.");
		return true;
	}

}
