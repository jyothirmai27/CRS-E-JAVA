/**
 * 
 */
package com.signify.bean;

import java.util.List;

/**
 * @author BHAVISH
 *
 */
public class Catalog {
	private int totalCourses;
	private int totalDepartments;
	private String department;
	private List<String> courseCodes;
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

	public List<String> getCourseCodes() {
		return courseCodes;
	}
	public void setCourseCodes(List<String> courseCodes) {
		this.courseCodes = courseCodes;
	}
	public String getProffesor() {
		return proffesor;
	}
	public void setProffesor(String proffesor) {
		this.proffesor = proffesor;
	}

}
