/**
 * 
 */
package com.signify.bean;

/**
 * @author CRS_SIGNIFY_GROUP_E
 *
 */
public class Admin {
	
	private String adminName;
	private String adminId;
	private String Password;
	
	// method to get admin name
	public String getAdminName() {
		return adminName;
	}
	//method to set admin name
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	//method to get admin Id
	public String getAdminId() {
		return adminId;
	}
	
	//method to set admin Id
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	//method to get Password
	public String getPassword() {
		return Password;
	}
	
	//method to set Password
	public void setPassword(String password) {
		Password = password;
	}
	

}
