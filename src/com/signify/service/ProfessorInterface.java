/**
 * 
 */
package com.signify.service;


/**
 * @author BHAVISH
 *
 */
public interface ProfessorInterface {
	
	public void changeGrade(String studentId, String grade, String courseCode);
	public void viewEnrolledStudents(String code);
	public void selectCourse() ;
	public void editDetails(String userId, String field, String correction);
	public void viewDetails();
}
