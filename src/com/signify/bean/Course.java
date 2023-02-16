package com.signify.bean;

public class Course {
	private String courseName;
	private String courseCode;
	private String departmentName;
	private String professorName;
	private boolean isOffered;
	private int enrolledStudent;
	private int semester;
	
	
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseId) {
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
	public boolean isOffered() {
		return isOffered;
	}
	public void setIsOffered(boolean isOffered) {
		this.isOffered = isOffered;
	}
	public int getEnrolledStudent() {
		return enrolledStudent;
	}
	public void setEnrolledStudent(int enrolledStudent) {
		this.enrolledStudent = enrolledStudent;
	}
	
}
