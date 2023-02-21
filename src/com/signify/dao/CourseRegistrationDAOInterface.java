/**
 * 
 */
package com.signify.dao;

/**
 * @author BHAVISH
 *
 */
public interface CourseRegistrationDAOInterface {
	
	public void addCourse(String student, String course);
	public void dropCourse(String student, String course);
	public void viewCourses(String Student);
	public void viewStudents(String course);
}
