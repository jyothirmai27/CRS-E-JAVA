package com.signify.bean;

import java.util.List;

public class Course {
	private String courseName;
	private String courseCode;
	private String departmentName;
	private String professorName;
	private boolean isOffered;
	private String semester;
	private List<String> enrolledStudents;
	private int enrolledStudentCount;
	
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
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
	public List<String> getEnrolledStudents() {
		return enrolledStudents;
	}
	public void setEnrolledStudents(List<String> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	public int getEnrolledStudentCount() {
		return enrolledStudentCount;
	}
	public void setEnrolledStudentCount(int enrolledStudentCount) {
		this.enrolledStudentCount = enrolledStudentCount;
	}
	public boolean isOffered() {
		return isOffered;
	}
	
}
