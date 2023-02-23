/**
 * 
 */
package com.signify.bean;

/**
 * @author BHAVISH
 *
 */
public class CourseRegistration {
	private String courseCode;
	private int semester;
	private int studentId;
	private String grade;
	
	
	//method to get course Code 
	public String getCourseCode() {
		return courseCode;
	}
	
	//method to set course Code 
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	//method to get semester
	public int getSemester() {
		return semester;
	}
	//method to set semester
	public void setSemester(int semester) {
		this.semester = semester;
	}
	//method to get StudentId
	
	public int getStudentId() {
		return studentId;
	}
	
	//method to set StudentId
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	//method to get Grade
	public String getGrade() {
		return grade;
	}
	
	//method to set Grade
	public void setGrade(String grade) {
		this.grade = grade;
}
}
