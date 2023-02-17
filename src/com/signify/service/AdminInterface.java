/**
 * 
 */
package com.signify.service;

import com.signify.bean.Admin;

/**
 * @author BHAVISH
 *
 */
public interface AdminInterface {
	
	public void assignCourse();
	public void addCourse();
	public void addAdmin(Admin admin);
	public void removeAdmin(Admin admin);
	public void dropCourse();
	public void generateReportCard();
	public void approveStudent();
	public void addProfessor();
	public void courseDetails();
	public void viewEnrolledStudents();

}
