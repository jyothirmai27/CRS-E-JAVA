/**
 * 
 */
package com.signify.bean;


public class Professor {
	private String designation;
	private String professorName;
	private String userId;
	private String departmentName;
	private String Password;
	private String phoneNumber;
	private String assignedCourse;


	public String getAssignedCourse() {
		return assignedCourse;
	}
	public void setAssignedCourse(String assignedCourse) {
		this.assignedCourse = assignedCourse;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
