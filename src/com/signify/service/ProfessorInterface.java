/**
 * 
 */
package com.signify.service;


/**
 * @author BHAVISH
 *
 */
public interface ProfessorInterface {
	
	public void changeGrade(String userId);
	public void viewEnrolledStudents();
	public void selectCourse() ;
	public void editDetails(String userId, String field, String correction);
	public void viewDetails();
}
