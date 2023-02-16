/**
 * 
 */
package com.signify.bean;

/**
 * @author BHAVISH
 *
 */
public class studentDetails {

	private String studentName;
	private String address;
	private String userId;
	private String branchName;
	private boolean registered;
	private boolean paymentdone;
	
	
	
	
	
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

}
