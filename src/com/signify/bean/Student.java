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
	public String semester ;
	
	

	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public boolean isSeeGrades() {
		return seeGrades;
	}
	public void setSeeGrades(boolean seeGrades) {
		this.seeGrades = seeGrades;
	}
	public boolean isScholarship() {
		return scholarship;
	}
	public void setScholarship(boolean scholarship) {
		this.scholarship = scholarship;
	}
	public String getScholarshipId() {
		return scholarshipId;
	}
	public void setScholarshipId(String scholarshipId) {
		this.scholarshipId = scholarshipId;
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
	public boolean isRegistered() {
		return registered;
	}
	public void setRegistered(boolean registered) {
		this.registered = registered;
	}
	public boolean isPaymentdone() {
		return paymentdone;
	}
	public void setPaymentdone(boolean paymentdone) {
		this.paymentdone = paymentdone;
	}

	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public List<String> getRegisteredCourses() {
		return registeredCourses;
	}
	public void setRegisteredCourses(List<String> registeredCourses) {
		this.registeredCourses = registeredCourses;
	}

	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}

}
