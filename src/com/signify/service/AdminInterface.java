/**
 * 
 */
package com.signify.service;

import com.signify.bean.Admin;
import com.signify.bean.Course;
import com.signify.bean.Professor;

/**
 * @author BHAVISH
 *
 */
public interface AdminInterface {
	
	public void assignCourse(String courseCode, String professorId);
	public void addCourse(Course course);
	public void dropCourse(String courseCode);
	public void generateReportCard();
	public void courseDetails();
	
	public boolean addAdmin(Admin admin);
	public void removeAdmin(Admin admin);
	public void editAdminDetails(Admin old, Admin admin);
	
	public void addProfessor(String userId, Professor professor);
	public void viewProfesssors();
	
	public void approveStudent();
	public void viewEnrolledStudents();
	

}
