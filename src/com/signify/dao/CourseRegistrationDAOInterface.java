/**
 * 
 */
package com.signify.dao;

import com.signify.exception.CourseAlreadyRegisteredException;
import com.signify.exception.CourseNotInRegisteredException;
import com.signify.exception.NoCourseRegisteredException;
import com.signify.exception.NoStudentsRegisteredForCourseException;
import com.signify.exception.PaymentDoneCourseNotAddedException;
import com.signify.exception.UserNotFoundException;

/**
 * @author BHAVISH
 *
 */
public interface CourseRegistrationDAOInterface {
	
	public void addCourse(String student, String course) throws CourseAlreadyRegisteredException, PaymentDoneCourseNotAddedException;
	public void dropCourse(String student, String course) throws CourseNotInRegisteredException, PaymentDoneCourseNotAddedException;
	public void viewCourses(String Student) throws NoCourseRegisteredException;
	public void viewStudents(String course) throws NoStudentsRegisteredForCourseException;
	public void addGrade(String student, String course, String grade) throws UserNotFoundException;
	public boolean getPaymentstatus(String studentId);
	public int countCourseStudent(String student);
	public boolean courseAvailableForSemester(String code, int sem);
}
