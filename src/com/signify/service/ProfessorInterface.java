/**
 * 
 */
package com.signify.service;


/**
 * @author BHAVISH
 *
 */
public interface ProfessorInterface {
	
	public void changeGrade();
	public void viewEnrolledStudents();
	public void selectCourse() ;
	public void editDetails(String userId, String field, String correction);
	public void viewDetails();
}
