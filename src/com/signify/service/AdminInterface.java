/**
 * 
 */
package com.signify.service;

import com.signify.bean.Admin;
import com.signify.bean.Course;
import com.signify.bean.Professor;
import com.signify.bean.User;

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
	
	public boolean addAdmin(Admin admin, User user);
	public void removeAdmin(Admin admin);
	public void editAdminDetails(Admin old, Admin admin);
	
	public void addProfessor(String userId, Professor professor);
	public void viewProfesssors();
	public void removeProfessor(String userId);
	
	public void approveStudent(String userId);
	public void viewEnrolledStudents();
	public void approveAllStudents();
	

}
