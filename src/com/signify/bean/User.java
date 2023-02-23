package com.signify.bean;

/**
 * @author CRS_SIGNIFY_GROUP_E
 *
 */
public class User {
	private String userId;
	private String name;
	private String role;
	private String password;
	
	//method to get password
	
	public String getPassword() {
		return password;
	}
	//method to set password
	public void setPassword(String password) {
		this.password = password;
	}
	//method to get UserID
	
	public String getUserId() {
		return userId;
	}
	//method to set UserID
	public void setUserId(String userId) {
		this.userId = userId;
	}
	//method to get Name
	public String getName() {
		return name;
	}
	//method to set Name
	public void setName(String name) {
		this.name = name;
	}
	//method to get Role
	public String getRole() {
		return role;
	}
	//method to set Role
	public void setRole(String role) {
		this.role = role;
	}

}
