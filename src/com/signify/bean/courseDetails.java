package com.signify.bean;

public class courseDetails {
	private String courseName;
	private String courseCode;
	private String departmentName;
	private String professorName;
	private boolean isOffered;
	private int enrolledStudent;
	
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseId() {
		return courseCode;
	}
	public void setCourseId(String courseId) {
		this.courseCode = courseId;
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
		return isOffered;
	}
	public void setCourseOffered(boolean courseOffered) {
		this.isOffered = courseOffered;
	}
	public int getEnrolledStudent() {
		return enrolledStudent;
	}
	public void setEnrolledStudent(int enrolledStudent) {
		this.enrolledStudent = enrolledStudent;
	}
	
}
