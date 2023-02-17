/**
 * 
 */
package com.signify.service;

import com.signify.bean.Student;

/**
 * @author BHAVISH
 *
 */
public interface StudentInterface {
	public void addStudent(Student student);
	public void viewGrades() ;
	public void viewCatelogs();
	public void addCourse();
	public void dropCourse();
	public void registerToCourse();
	public void editDetails();
	public void makePayment();

}
