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


	//method to get AssignedCourse
	public String getAssignedCourse() {
		return assignedCourse;
	}
	//method to set AssignedCourse
	public void setAssignedCourse(String assignedCourse) {
		this.assignedCourse = assignedCourse;
	}
	//method to get PhoneNumber
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	//method to set PhoneNumber
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	//method to get Password
	public String getPassword() {
		return Password;
	}
	//method to set Password
	public void setPassword(String password) {
		Password = password;
	}
	
	//method to get DepartmentName
	
	public String getDepartmentName() {
		return departmentName;
	}
	//method to set DepartmentName
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	//method to get Designation
	
	public String getDesignation() {
		return designation;
	}
	
	//method to set Designation
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	//method to get Professor Name
	public String getProfessorName() {
		return professorName;
	}
	//method to set Professor Name
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	//method to get UserID
	public String getUserId() {
		return userId;
	}
	//method to set UserID
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
