/**
 * 
 */
package com.signify.bean;

/**
 * @author BHAVISH
 *
 */
public class Catalog {
	private int totalCourses;
	private int totalDepartments;
	private String department;
	private String courseCodes;
	private String proffesor;
	
	public int getTotalCourses() {
		return totalCourses;
	}
	public void setTotalCourses(int totalCourses) {
		this.totalCourses = totalCourses;
	}
	public int getTotalDepartments() {
		return totalDepartments;
	}
	public void setTotalDepartments(int totalDepartments) {
		this.totalDepartments = totalDepartments;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCourseCodes() {
		return courseCodes;
	}
	public void setCourseCodes(String courseCodes) {
		this.courseCodes = courseCodes;
	}
	public String getProffesor() {
		return proffesor;
	}
	public void setProffesor(String proffesor) {
		this.proffesor = proffesor;
	}

}
