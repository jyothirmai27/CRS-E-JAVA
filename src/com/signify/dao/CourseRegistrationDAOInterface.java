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
	
	/*
	  method to add course
	  @param course     represents the course
	  @param student    represents the student
	 */
	public void addCourse(String student, String course) throws CourseAlreadyRegisteredException, PaymentDoneCourseNotAddedException;
	
	/*
	  method to drop course
	  @param course     represents the course
	  @param student    represents the student
	 */
	public void dropCourse(String student, String course) throws CourseNotInRegisteredException, PaymentDoneCourseNotAddedException;
	
	/*
	  method to view courses
	  @param student    represents the student
	 */
	public void viewCourses(String Student) throws NoCourseRegisteredException;
	
	/*
	  method to view courses
	  @param course     represents the course
	 */
	public void viewStudents(String course) throws NoStudentsRegisteredForCourseException;
	
	/*
	  method to add the grade
	  @param course     represents the course
	  @param student    represents the student
	  @param grade      represents the grade
	 */
	public void addGrade(String student, String course, String grade) throws UserNotFoundException;
	
	/*
	  method to get the payment status
	  @param studentId unique id to represent the student
	 */
	public boolean getPaymentstatus(String studentId);
	public int countCourseStudent(String student);
	public boolean courseAvailableForSemester(String code, int sem);
}
