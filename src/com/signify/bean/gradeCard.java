/**
 * 
 */
package com.signify.bean;

import java.util.List;

/**
 * @author BHAVISH
 *
 */
public class GradeCard {
	
	private int studentId;

	private int semester;
	private float cpi;
	private List registeredCourses;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public float getCpi() {
		return cpi;
	}
	public void setCpi(float cpi) {
		this.cpi = cpi;
	}
	public List getRegisteredCourses() {
		return registeredCourses;
	}
	public void setRegisteredCourses(List registeredCourses) {
		this.registeredCourses = registeredCourses;
	}
	
	public float calculateCpi() {
		float cpi = 0.0f; //calculate cpi
		return cpi;
	}
	

}
