/**
 * 
 */
package com.signify.dao;

import com.signify.bean.Course;
import com.signify.exception.CourseAlreadyRegisteredException;
import com.signify.exception.CourseNotFoundException;
import com.signify.exception.NoCourseException;

/**
 * @author BHAVISH
 *
 */
public interface CourseDAOInterface {
	
	public void add(Course course) throws CourseAlreadyRegisteredException;
	public void remove(String courseCode) throws CourseNotFoundException;
	public void update(String query);
	public void view() throws NoCourseException;
	public void viewCoursesForSemester(int sem) throws NoCourseException;
	

}
