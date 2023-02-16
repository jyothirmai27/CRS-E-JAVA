package com.signify.bean;

public class courseDetails {
	private String courseName;
	private String courseId;
	private String departmentName;
	private String professorName;
	private boolean courseOffered;
	private int enrolledStudent;
	
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public boolean isCourseOffered() {
		return courseOffered;
	}
	public void setCourseOffered(boolean courseOffered) {
		this.courseOffered = courseOffered;
	}
	public int getEnrolledStudent() {
		return enrolledStudent;
	}
	public void setEnrolledStudent(int enrolledStudent) {
		this.enrolledStudent = enrolledStudent;
	}
	
}
