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
	
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	public Date getDateofRegistration() {
		return dateofRegistration;
	}
	public void setDateofRegistration(Date dateofRegistration) {

		this.dateofRegistration = dateofRegistration;
	}
}
