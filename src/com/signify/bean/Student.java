/**
 * 
 */
package com.signify.bean;

import java.util.List;

/**
 * @author BHAVISH
 *
 */
public class Student {

	private String studentName;
	private String address;
	private String userId;
	private String branchName;
	private boolean registered;
	private boolean paymentdone;
	private String Password;
	private String scholarshipId;
	private List<String> registeredCourses;
	private String batch;
	private boolean scholarship;
	private String phoneNumber;
	private boolean seeGrades;
	public String semester;
	
	
	//method to get semester
	public String getsemester() {
		return semester;
	}
	//method to set semester
	public void setSemester(String semester) {
		this.semester = semester;
	}	
	
	public boolean isSeeGrades() {
		return seeGrades;
	}
	//method to set see grades
	public void setSeeGrades(boolean seeGrades) {
		this.seeGrades = seeGrades;
	}
	//To check the student has scholarship
	public boolean isScholarship() {
		return scholarship;
	}
	//method to set scholarship
	public void setScholarship(boolean scholarship) {
		this.scholarship = scholarship;
	}
	//method to get scholarshipID
	public String getScholarshipId() {
		return scholarshipId;
	}
	//method to set scholarshipID
	public void setScholarshipId(String scholarshipId) {
		this.scholarshipId = scholarshipId;
	}	
	//method to get Phone Number
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	//method to set Phone Number
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	//method to get passsword
	public String getPassword() {
		return Password;
	}
	
	//method to set passsword
	public void setPassword(String password) {
		Password = password;
	}
	//method to check is registered or not	
	public boolean isRegistered() {
		return registered;
	}
	public void setRegistered(boolean registered) {
		this.registered = registered;
	}
	// to check the  payment is done
	public boolean isPaymentdone() {
		return paymentdone;
	}
	public void setPaymentdone(boolean paymentdone) {
		this.paymentdone = paymentdone;
	}
	//method to get student Name
	public String getStudentName() {
		return studentName;
	}
	//method to set student Name
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	//method to get Address
	public String getAddress() {
		return address;
	}
	//method to set Address
	public void setAddress(String address) {
		this.address = address;
	}
	//method to get userId
	public String getUserId() {
		return userId;
	}
	//method to set userId
	public void setUserId(String userId) {
		this.userId = userId;
	}
	//method to get Branch Name
	public String getBranchName() {
		return branchName;
	}
	
	//method to set Branch Name
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	//method to get registered course
	public List<String> getRegisteredCourses() {
		return registeredCourses;
	}
	//method to set registered course
	public void setRegisteredCourses(List<String> registeredCourses) {
		this.registeredCourses = registeredCourses;
	}
	//method to get Batch
	public String getBatch() {
		return batch;
	}
	//method to set Batch
	public void setBatch(String batch) {
		this.batch = batch;
	}

}
