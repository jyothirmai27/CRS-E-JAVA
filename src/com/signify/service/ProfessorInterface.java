/**
 * 
 */
package com.signify.service;


/**
 * @author BHAVISH
 *
 */
public interface ProfessorInterface {
	/**
	 * 
	 * @param studentId
	 * @param grade
	 * @param courseCode
	 * to change grades of the student
	 */
	public void changeGrade(String studentId, String grade, String courseCode);
	/**
	 * 
	 * @param code
	 * to view all the enrolled students
	 */
	public void viewEnrolledStudents(String code);
	/**
	 * Selecting course by the professor
	 */
	public void selectCourse() ;
	/**
	 * 
	 * @param userId
	 * @param field
	 * @param correction
	 */
	public void editDetails(String userId, String field, String correction);
	public void viewDetails();
}
