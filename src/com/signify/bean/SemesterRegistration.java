/**
 * 
 */
package com.signify.bean;

import java.util.Date;

/**
 * @author BHAVISH
 *
 */
public class SemesterRegistration {
	private int StudentId;
	private int semester;
	private Date dateofRegistration;
	//method to get student ID
	public int getStudentId() {
		return StudentId;
	}
	//method to set student ID
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	//method to get semester
	
	public int getSemester() {
		return semester;
	}
	//method to set semester
	public void setSemester(int semester) {
		this.semester = semester;
	}
	//method to get tDate of Registration
	
	public Date getDateofRegistration() {
		return dateofRegistration;
	}
	//method to set Date of Registration
	public void setDateofRegistration(Date dateofRegistration) {

		this.dateofRegistration = dateofRegistration;
	}
}
