/**
 * 
 */
package com.signify.service;

import com.signify.bean.Professor;

/**
 * @author BHAVISH
 *
 */
public interface ProfessorInterface {
	public void addProfessor(Professor professor);
	public void changeGrade();
	public void viewEnrolledStudents();
	public void selectCourse() ;
	public void editDetails();
	public void viewDetails();
}
